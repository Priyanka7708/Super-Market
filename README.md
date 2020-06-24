
This project provides the code for a model of a supermarket. 
The supermarket's inventory consists of _products_ that can be sold _by unit_ (e.g. a can of baked beans) or _by weight_
(e.g. loose carrots).
The total price of a shopping basket has currently been calculated as a simple sum of its items. 
  
The supermarket offers _pricing discount_ schemes, for example:
- Buy one, get one free
- Buy two items for £1
- Buy three items for the price of two
- Buy one kilo of vegetables for half price

Some discounts would be applicable for single products (e.g. a can of baked beans), while others could apply across a 
group of products (e.g. vegetables).

The extended functionality of Basket is implemented _a component_ that can calculate the __total amount__ 
to pay for the items in a basket, __including any discounts that would be applicable__ for the current state of the 
basket.

All discount schemes are implemented and more can be added easily.

