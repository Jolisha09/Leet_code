select distinct num  AS ConsecutiveNums
from Logs
where (id+1,num) in (select id,num from Logs)
AND (id+2,num) in (select id,num from Logs);