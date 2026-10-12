## Hash Table Experiments and Analysis
### Due Mon, Oct 19, start of class
### Submit via Gitlab

In this folder, there is a working version of programming assignment 5 on Hash Tables, along with a TestHash.java file. When you run the TestHash file, you will see a collection of runtime results for different sized hash tables using the 3 different hash functions. Use these files to conduct 2 experiments and provide a report as a markdown file.


### Running the Experiments

1. Run `TestHash.java`. It might take a minute or two to run the 50,000 element experiment, depending on how fast your computer is.

2. Save the results in a file *results\_equal.txt*. You can either 1) export text from the terminal using the pulldown menu options, 2) copy and paste from your terminal or 3) export to a text file when you run it: `javaTestHash > results_equal.txt`

3. Adjust the table size to 1/10th of the number of elements. This can be done in the for loop in the efficiencyTest method. For example, add 1000 elements to a table of length 100. 

4. Run TestHash.java again.

5. Save the results in a file *results\_tenth.txt**. 


### Visualize the Results (Tabular)

Create a markdown file called *report.md* and present the results in tabular form.

- Table I: Runtime (in ms) based on the experiment when the table is on scale with the number of elements.
	
- Table II: Runtine (in ms) based on the experiment when the table is 1/10th of the number of elements.
	
Here is a template for the table:

| | 1k | 5k | 10k | 25k | 50k |
|-------|----|----|-----|-----|-----|
| hashA |    |    |     |     |     |
| hashB |    |    |     |     |     |
| hashC |    |    |     |     |     |

	

### Visualize the Results (Graph)

Visualize the same data using a line graph. You can do this in Excel, R, python, or any other program that you know of that can create LINE graphs (not bar graphs) then export the graph into this document. Each of the 2 graphs should have 3 lines, each representing one of the three hash functions. The lines should be distinguishable and clearly keyed (i.e. create a legend). The x-axis is the n value and the y-axis is the runtime. 

NOTE: it is important that the x-axis is scaled properly. In other words, the distance between each "n" reflects their difference. There should be 4k "units" between 1k and 5k, and 25k "units" between 25k and 50k. You are welcome to work with others in the class or AI to make the graph work for YOUR data.

### Present Your Analysis

Explain the results for each of the tables/graphs. Use the information about linked list length to explain why you see such dramatic differences. Use big-O notation (e.g. O(1), O(n)) as part of your explanation. This part you do independently. Your answer should reflect your thinking and your writing. Cite any resources that you use.

<hr>

The structure of the document should be:

1. Introduction to the experiments that were run.
2. Table I followed by the same data visualized as a graph.
3. Analysis of the the data for this experiment.
4. Table II followed by the same data visualized as a graph.
5. Analysis of the data for this experiment with the smaller table.


