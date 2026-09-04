# Programming Assignment 01 : Comparing the Efficiency of Data Structures
## Due Thursday, September 10 end-of-day
## Submit via Gitlab

In this programming assignment, you will conduct a series of experiments that access and modify data stored in two different ways, namely an ArrayList and LinkedList. Each experiment applies an operation on the data, tracking the time and RAM (memory) usage, to measure efficiency of the two data structures. This assignment motivates the rest of the course, highlighting the importance of choosing the right data structure. This is an empirical (i.e. by experiment) comparison. Later in the semester, we will conduct a theoretical comparison. 

#### Learning Objectives

- Know that the choice of data structure impacts efficiency with respect to both time and space.
- Run Java code to conduct a series of experiments and collect data.
- Use command-line execution with command-line arguments.
- Create a markdown file with embedded images.
- Use a Java Iterator to traverse a structure.
- Use github to access an assignment.
- Use gitlab to submit an assignment.

All code has been provided for you. It uses Java's built-in ArrayList and LinkedList to store data randomly generated with _DataMaker.java_. The file _Experiment.java_ applies an operation to that data and records its efficiency. The script _plot\_compariosn.py_ graphs the results. Your job is to learn how to use these files then compile the results into a markdown file.

<hr>

Follow these instructions to complete the assignment.

#### FIRST, get your system ready by cloning the repos on Github and Gitlab. Directions are here: https://github.com/lars1050/csc341-f26

> For this course, you are expected to use either BBedit for Macs or Notepad++ for Windows (or some other editor that does not write code for you). During class and during periodic meetings with Dr. Larson, you will be asked to edit code in an editor and run it from a shell (terminal). 

### Run the Experiments

The three steps below provide instructions to run an experiment.
 
1. Create a data file for running the experiments. Compile the code and execute it as indicated below. This will create a file and place it in the _data_ folder.

	```
	java DataMaker -s 1000000 -o basic1M.csv
	```

2. Run an experiment using the data file from #1 and collect timing data for a given operation. Run _Experiment_ as indicated below to measure the efficiency of the operator (choosing from add, traverse, get, and remove). This will read the basic1M.csv file from the data directory and place the results in add1M.csv in the data directory.

	```
	java Experiment -op add -source basic1M.csv -output add1M.csv
	```

3. Graph the data collected using the Python script, executing as indicated below. **First, you have to _cd_ into the data directory**. This will create plots, display them, and save them as .png files.

	```
	cd data
	python3 plot_comparison.py -f add1M.csv
	```

There are 5 different experiments to run and collect data on. For each experiment listed below, follow the three steps above. Be sure to change the filenames for the different sizes and operations.

1. Operation _add_ on data structures with 1 million elements (exactly as above).

2. Same as #1, but when you run the Experiment, use this command instead:

	```java -Xmx4g -Xms4g Experiment -op add -source basic1M.csv -output addMemory1M.csv```
	
	> Feel free to ask AI what this is doing and why the data looks so different relative to running it without the -X flags.

3. Operation _traverse_ with 1 million elements.

4. Operation _get_ with 250000 elements. This will likely take at least 5 minutes to complete. If it seems like it will take 30+ minutes, demonstrate to Dr. Larson the timing and we will determine how big of a dataset to use.

5. Operation _remove_ with 250000 elements. This will also take several minutes.

When complete, you should have:
- 2 csv files that contain the randomly generated _Basic_ items, 
- 5 csv files that contain data from running experiments
- 7 png files of plots based on the experiments


### Visualizing the Results

Create a single markdown document called _results.md_ in the directory _data_. In the document:

- create a meaningful title for the document (in a large font), 
- include your name at the top, 
- create a title for each experiment (in a smaller font than the document title), 
- embed the corresponding png image(s) under the experiment title (for the add operation, put the time and memory plots side-by-side for each of the 2 experiments), and
- create a figure legend for each of the 5 experiments. The legend should state what experiment was run and provide a single concluding sentence about the data (_as the semester progresses, we will refer back to these images to gain a better understanding of the results_). 

Below are some references on how to make a markdown file. FYI, _this_ is a markdown file. If you look at it "raw" in github, you will see how the "syntax" translates into formatted text.

- https://www.markdownguide.org/
- https://www.writethedocs.org/guide/writing/markdown/
- https://www.youtube.com/watch?v=LxeclcePg-c
- https://www.youtube.com/watch?v=Gv1gmbtIOXQ

### Sharing the Results

Push your folder to gitlab for submission. View the markdown file through the github site on your browser.

> Notice that your .csv and .png files are not being pushed to github. When you meet with Dr. Larson, we will fix this together.

**Make an appointment with Dr. Larson to discuss your work and submission (using this link: https://calendar.app.google/mPxgKEghLWM13TUHA.**

During the meeting, you will be asked to do the following:

- Open a terminal and navigate to the folder with this assignment.
- Run the DataMaker, Experiment, and plot-comparison.py from the shell.
- Open the .gitignore file in your code editor to modify the file.
- Push the changes to your gitlab account (using the command line).
- Review your gitlab account through your browser.
