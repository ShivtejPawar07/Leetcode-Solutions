# Write your MySQL query statement below
select product_name,year,price
from product p
right join sales s
on p.product_id=s.product_id