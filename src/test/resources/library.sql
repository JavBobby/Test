-- US 01
select count(id)
from users;
--
-- 1855

select count(distinct id)
from users;
-- 1855


-- RESULT --> MANUALLY IT IS PASSED


-- US 02
select *
from users;

select *
from users
where email = 'student5@library';


-- US 03
select count(*)
from book_borrow
where is_returned = 0;

-- US 07 Bobby
select *
from books;

select *
from books
where id = '8924';

select *
from book_borrow;
select *
from book_borrow
where book_id = '8924';

select count(*)
from books B
         join book_borrow bb on B.id = bb.book_id;

select *
from book_borrow bb
         inner join books b on bb.book_id = b.id
         inner join users u on bb.user_id = u.id
where u.id = '5757'
  and bb.is_returned = 0
  and b.id = '8924';

select u.id
from book_borrow bb
         join books b on bb.book_id = b.id
         join users u on bb.user_id = u.id
where bb.is_returned = 0
  and b.id = '8924';

select *
from books B
         join book_borrow bb on B.id = bb.book_id
where bb.book_id = '8924'
  and bb.is_returned < 1;

select full_name, b.name, bb.borrowed_date
from users u
         inner join book_borrow bb on u.id = bb.user_id
         inner join books b on bb.book_id = b.id
where full_name = 'Test Student 5'
  and name = 'Bobby Book'
order by 3 desc;

select count(*) from book_borrow where is_returned=0;

select name from book_categories;