# Write your MySQL query statement below
SELECT p.firstName, p.lastname, a.city, a.state
from Person p
left join address a
on p.personId = a.personId; 