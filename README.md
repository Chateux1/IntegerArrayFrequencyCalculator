Integer Value Frequency Calculator
==================================

**The goal of this project is to visually display how frequent each integer
appears in an array.** 

*The first commit was made not at the beginning of the project so some
development stages are lost. This is a beginner project to learn java from scratch.*

Version 1.0
-----------

**Main Window**

- three buttons to input and reset data and to open visual representation
- input field
- label with information about what should be entered

**Number Array**

- frequencies are calculated here

**GraphWindow**

- when button continue is pressed in main window a new JFrame appears with visual frequency representation

TO DO
-----

- 'Enter' and 'Continue' buttons should probably be merged
- 'NumberArray' class has many get/set methods, they should be checked whether are needed
- 'GraphWindow' does not display zeros as per assignment requirements, but it seems logical to include it. Otherwise there should validation to not allow zero to be input
- as of now it is possible to open multiple 'GraphWindows', it should be disabled (switch to JDialog?)
- add feature to choose console or GUI input method at the start of the program