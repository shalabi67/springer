# Springer challenge 
a simple console version of a drawing program. At this time,

the functionality of the program is quite limited but this might change in the future. In a nutshell , the program should work as follows:
1. create a new canvas
2. start drawing on the canvas by issuing various commands
3. quit

At the moment, the program should support the following commands:

#### **C w h** Should create a new canvas of width w and height h.

#### **L x1 y1 x2 y2** Should create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the 'x' character.

#### **R x1 y1 x2 y2** Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character.

#### **B x y c** Should fill the entire area connected to (x,y) with "color" c. The behavior of this is the same as that of the "bucket fill" tool in paint programs.

#### Q Should quit the program.



## Design
