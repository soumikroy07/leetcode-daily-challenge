# Write your MySQL query statement below
select em.name as Employee from Employee em
join Employee ep on em.managerId = ep.id
where em.salary > ep.salary;