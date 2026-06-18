# Write your MySQL query statement below
select id,
CASE
when p_id is NULL then 'Root'
when id IN(SELECT p_id from tree) then 'Inner'
else 'Leaf'
END AS type
FROM tree;