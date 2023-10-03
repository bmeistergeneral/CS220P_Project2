# CS220P_Project2
This project is code given to me by my Data Structures teacher for review and testing to
fix errors, but there is only one error that was fixed, and that was with the result
variable in the converttoString() method. It is an implementation of a singly linked list
that can add or remove the first elements in the linked list, checks if there is a next
node, creates a linked list iterator, etc. The main method creates a new linked list and 
adds five different nodes as the first element using the addFirst() method. It then calls the
converttoString() method on the linked list to convert it to a string, and with the stack nature
of the linked list, the linked list is printed out backwards. There seems to be a small typo
in the output, as the final result is ed, c, b, a, and not e, d, c, b, a. But the project works 
as it should work.