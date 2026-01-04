# Write your MySQL query statement below
select *
from cinema
where id%2!=0 && description!='boring'
order by rating desc;