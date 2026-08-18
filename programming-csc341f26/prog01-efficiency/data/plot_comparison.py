#!/usr/bin/env python3
"""
Plot the results produced by Experiment.java as line graphs.

The first column of the csv is used as the x-axis (e.g. size). Each
remaining column is drawn as its own line on the y-axis. If the file
has 5 columns (size, arraytime, linkedtime, arrayram, linkedram), two
separate graphs are created -- one comparing time, one comparing memory.

Usage: python3 plot_comparison.py -f getTest.csv
"""

import argparse
import csv
import os

import matplotlib.pyplot as plt


def read_csv(filename):
    with open(filename, newline="") as f:
        reader = csv.reader(f)
        header = next(reader)
        rows = [row for row in reader if row]

    x_label = header[0]
    x_values = [float(row[0]) for row in rows]

    y_labels = header[1:]
    y_columns = [[float(row[i]) for row in rows] for i in range(1, len(header))]

    return x_label, x_values, y_labels, y_columns


def plot_lines(x_label, x_values, y_labels, y_columns, title, out_filename):
    plt.figure()
    for label, values in zip(y_labels, y_columns):
        plt.plot(x_values, values, marker="o", label=label)
    plt.xlabel(x_label)
    plt.ylabel(title)
    plt.title(title + " vs " + x_label)
    plt.legend()
    plt.tight_layout()
    plt.savefig(out_filename)
    print("Wrote " + out_filename)


def main():
    parser = argparse.ArgumentParser(description="Plot Experiment.java csv results as line graphs.")
    parser.add_argument("-f", "--file", required=True, help="csv file to plot")
    args = parser.parse_args()

    x_label, x_values, y_labels, y_columns = read_csv(args.file)
    base = os.path.splitext(args.file)[0]

    if len(y_labels) == 4:
        # size,arraytime,linkedtime,arrayram,linkedram -- split time vs memory
        plot_lines("n (number of elements)", x_values, "runtime (ns)", y_columns[0:2],
                   "Time", base + "_time.png")
        plot_lines("n (number of elements)", x_values,"memory (bytes)", y_columns[2:4],
                   "Memory", base + "_memory.png")
    else:
        plot_lines("n (number of elements)", x_values, "runtime (ns)", y_columns,
                   "Runtime", base + ".png")

    plt.show()


if __name__ == "__main__":
    main()
