# Notes
Implemented 4 different discount schemes :
1) Buy one get one free
- Assumption was made that this will be only applied items by unit
- Also assumed the discount will be on the cheapest item, hence sorting the list of items by price

2) By two items for 1 pound
- If we have two items for price 0.75 and 1 which sums to 1.75; 
Now as soon as we get to the second item, we calculate the discount which will be 1.75 - 1 = 75p 
- Assumption again that the item price/ total sum > 1, otherwise not considered as discount.

3) Buy three items for the price of two
- Getting all the items belonging to this type of discount, sort the list by price.
- Now since it's sorted and the discount will be on the cheapest item, get the total number of set that will be formed with 3 items.

4) Buy one kilo of products for half price
- Currently this one doesn't handle multiple different products that makes >= 1  kilo as that would need more comlicated calculation on which price to consider.
Have currently implemented the way mentioned below :
- For e.g if the basket as 500 grams of carrots and 1 kg of potatoes, the discount will only appear for 1 kg of potatoes.
- Similarly if there is 500 grams of carrots and 500 grams of potatoes, no discount will be applied even though they together make 1 kg. 

