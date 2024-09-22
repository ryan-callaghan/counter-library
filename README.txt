Counter Library Project for Maxeta Technologies Internship Application.

Overview:
This project implements a Counter class that represents a time of day, with hour, minute, and second increments.
The counter may be initialized to any time between 00:00:00 and 23:59:59.
Increments by 1 can be made to each of the units of time using the increment methods.
Decrements of 1 can also be made to each unit using the decrement methods, however it is not possible to decrement below 0.
The counter is initialized as 00:00:00 when no parameters are entered, and upon initialization it is in the military time format.
To switch to standard time, a user must call the toStandard() method on the conuter instance.
A counter object can also be switched back to military from standard by using the toMilitary() method.
To print a counter object, the user must use the toString() method.


Developed by Ryan Callaghan