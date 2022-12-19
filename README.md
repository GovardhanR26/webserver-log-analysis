# webserver-log-analysis

In this project, we aim to perform an analysis of the web server logs. We aim to address
questions such as
* How many hits were made to a particular resource?
* How many hits were made by a particular IP address?
* Which is the most popular file in the website?
* What time of the day is the traffic highest?

A visual representation of the analysis will help us address measures that can improve the performance of the web server.

<h3>DESIGN</h3>
The dataset containing web server logs has been taken from Kaggle (https://www.kaggle.com/datasets/dsfelix/access-log) datasets. The dataset is a <i>txt</i> file containing the following fields

* Client IP address
* Date & Time
* Requested URL (HTTP Method + URL)
* Status Code

We have set up a pseudo-distributed cluster where we store the data and perform MapReduce tasks. We push the dataset into the Hadoop filesystem for it to be further processed. The file which is of around 500 MB will be split into 4 blocks to be stored in HDFS.

For each of the asked questions, we have designed MapReduce programs which perform processing and give the required output. The Mapper takes the logs.txt as input and performs the first stage of processing and gives out the intermediate output. The Reducer then takes this data and performs the final process, and we obtain the final output.

The output of the MapReduce task is the count of the queried fields. However, in order to achieve a meaningful analysis, we use a Jupyter Notebook. We take the Reducer output, and copy it onto the local disk. We read this file inside the Notebook and assign the pandas dataframe with appropriate column names. We then sort the dataframe in the descending order according to the count, so that we are now able to list the characteristics in an order where the most frequent values are at the top.

Visualization goes a long way in helping understand the various insights obtained from data analysis. We use the python matplotlib library to construct visualizations that depict the trends observed in the data. Pie charts have been constructed using the above-mentioned library that show the distribution of the considered characteristic in the dataset.

