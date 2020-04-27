
###How to execute WordService tests ###
1. Download install java jdk-8++,  (instruction can be found here - https://java.com/en/download/help/download_options.xml)

2. Download install gradle use 6.2.2, (instruction can be found here - https://gradle.org/install/)

3. In the project root open a terminal session and type  'gradle clean test --info' to run the tests. 

4. Order to view the test report type file://{check-out-dir}/JavaJobTest/build/reports/tests/test/index.html in browser url.

Assumptions
- Sentence cannot be empty
- Two or more words are matched the first word matched in the sentence is returned.
- Punctuations and number are ignored.
- Charcater encoding is UTF-8 
