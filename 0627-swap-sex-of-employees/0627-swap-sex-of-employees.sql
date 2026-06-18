# Write your MySQL query statement below
update salary
set sex=
CASE
when sex='m' then 'f'
else 'm'
END
