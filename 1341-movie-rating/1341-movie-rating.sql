# Write your MySQL query statement below
-- Find user with most ratings
WITH UserRatings AS (
    SELECT 
        u.name,
        COUNT(*) AS cnt
    FROM MovieRating mr
    JOIN Users u ON mr.user_id = u.user_id
    GROUP BY u.name
),
TopUser AS (
    SELECT name
    FROM UserRatings
    WHERE cnt = (SELECT MAX(cnt) FROM UserRatings)
    ORDER BY name
    LIMIT 1
),

-- Find movie with highest average rating in Feb 2020
MovieRatingsFeb AS (
    SELECT 
        m.title,
        AVG(mr.rating) AS avg_rating
    FROM MovieRating mr
    JOIN Movies m ON mr.movie_id = m.movie_id
    WHERE mr.created_at BETWEEN '2020-02-01' AND '2020-02-29'
    GROUP BY m.title
),
TopMovie AS (
    SELECT title
    FROM MovieRatingsFeb
    WHERE avg_rating = (SELECT MAX(avg_rating) FROM MovieRatingsFeb)
    ORDER BY title
    LIMIT 1
)

-- Combine results
SELECT name AS results FROM TopUser
UNION ALL
SELECT title AS results FROM TopMovie;
