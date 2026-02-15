# Write your MySQL query statement below
WITH friend_counts AS (
    SELECT id, COUNT(DISTINCT friend_id) AS num
    FROM (
        SELECT requester_id AS id, accepter_id AS friend_id
        FROM RequestAccepted
        UNION ALL
        SELECT accepter_id AS id, requester_id AS friend_id
        FROM RequestAccepted
    ) AS all_friends
    GROUP BY id
)
SELECT id, num
FROM friend_counts
WHERE num = (SELECT MAX(num) FROM friend_counts);
