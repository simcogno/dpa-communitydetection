# Girvan-Newman Algorithm Implementation
This is an Girvan-Newman Algorithm implementation based on the paper "Finding and Evaluating Community Structure in Networks". In the repository DPA.ipynb is the actual code implementation and written in python. 

# Prerequisite
Installation of the python, package manager pip and Jupyter Notebook. It is possible to run Jupyter Notebook with pycharm, otherwise it requires to download anaconda. 

## Library Installation
These are the necessary libraries to run the python script. 
```bash
pip install matplotlib==3.1.2
pip install networkx==2.2
pip install scipy==1.4.1
```

## Usage
Python script can run with unweighted and weighted graph. In order to run with unweighed graph, In the line [2], G.edges[edge]['og_weight'] = 1 must be uncommented to add weight to the graph. However, if you are running with weighted graph it should stay commented. 
```python
for edge in G.edges:
    #set all the betweenness score to 0 to initalize
    G.edges[edge]['weight'] = 0
    #if there are no weights in the Graph, uncomment this line to set all the weights to 1
    #G.edges[edge]['og_weight'] = 1
```
The readGraphFrom function will read any given input data, by changing the input name it will switch to a new graph. 
```python
G = readGraphFrom("graph.txt")
```

## License
This implementation is done for the DPA course project.
