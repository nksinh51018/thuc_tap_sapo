-- insert table kho
INSERT INTO kho (ma_kho, ten, dia_diem, ngay_tao, ngay_sua) VALUES ('001', 'Kho so 2', 'Ha Noi', '2020-08-06', '2020-08-06');
INSERT INTO kho (ma_kho, ten, dia_diem, ngay_tao, ngay_sua) VALUES ('002', 'Kho so 2', 'Ha Noi', '2020-08-06', '2020-08-06');
INSERT INTO kho (ma_kho, ten, dia_diem, ngay_tao, ngay_sua) VALUES ('003', 'Kho so 3', 'Ha Noi', '2020-08-06', '2020-08-06');
INSERT INTO kho (ma_kho, ten, dia_diem, ngay_tao, ngay_sua) VALUES ('004', 'Kho so 4', 'Ha Noi', '2020-08-06', '2020-08-06');
INSERT INTO kho (ma_kho, ten, dia_diem, ngay_tao, ngay_sua) VALUES ('005', 'Kho so 5', 'Ha Noi', '2020-08-06', '2020-08-06');

-- update table kho
UPDATE kho 
SET ten = 'Kho so 1'
WHERE (id = 1);

-- delete row in table kho
DELETE FROM kho 
WHERE (id = 2);

-- insert table loai_danh_muc
INSERT INTO loai_danh_muc (ma_loai_danh_muc, ten, mo_ta, ngay_tao, ngay_sua) VALUES ('001', 'Danh muc 2', 'Danh muc chua cac san pham loai so 2', '2020-08-06', '2020-08-06');
INSERT INTO loai_danh_muc (ma_loai_danh_muc, ten, mo_ta, ngay_tao, ngay_sua) VALUES ('002', 'Danh muc 2', 'Danh muc chua cac san pham loai so 2', '2020-08-06', '2020-08-06');
INSERT INTO loai_danh_muc (ma_loai_danh_muc, ten, mo_ta, ngay_tao, ngay_sua) VALUES ('003', 'Apple', 'Danh muc chua cac san pham loai so 3', '2020-08-06', '2020-08-06');
INSERT INTO loai_danh_muc (ma_loai_danh_muc, ten, mo_ta, ngay_tao, ngay_sua) VALUES ('004', 'Danh muc 4', 'Danh muc chua cac san pham loai so 4', '2020-08-06', '2020-08-06');
INSERT INTO loai_danh_muc (ma_loai_danh_muc, ten, mo_ta, ngay_tao, ngay_sua) VALUES ('005', 'Danh muc 5', 'Danh muc chua cac san pham loai so 5', '2020-08-06', '2020-08-06');

-- update table loai_danh_muc
UPDATE loai_danh_muc 
SET ten = 'Danh muc 1',
	mo_ta = 'Danh muc chua cac san pham loai so 1'
WHERE (id = 1);

-- delete row in table loai_danh_muc
DELETE FROM loai_danh_muc
WHERE (id = 2);

-- insert table san_pham
INSERT INTO san_pham (ma_san_pham, danh_muc, kho, ten, mo_ta_san_pham, duong_dan_anh, so_luong_san_pham, so_luong_ban, ngay_tao, ngay_sua) VALUES ('001', '1', '1', 'Điện thoại abc', 'San pham tot', 'https://mywebsite.com/sanpham1', '20', '5', '2020-08-06', '2020-08-06');
INSERT INTO san_pham (ma_san_pham, danh_muc, kho, ten, mo_ta_san_pham, duong_dan_anh, so_luong_san_pham, so_luong_ban, ngay_tao, ngay_sua) VALUES ('002', '2', '1', 'abc Điện thoại', 'San pham tot', 'https://mywebsite.com/sanpham1', '20', '10', '2020-08-06', '2020-08-06');
INSERT INTO san_pham (ma_san_pham, danh_muc, kho, ten, mo_ta_san_pham, duong_dan_anh, so_luong_san_pham, so_luong_ban, ngay_tao, ngay_sua) VALUES ('003', '3', '1', 'abc Điện thoại abc', 'San pham tot', 'https://mywebsite.com/sanpham1', '20', '10', '2020-08-06', '2020-08-06');
INSERT INTO san_pham (ma_san_pham, danh_muc, kho, ten, mo_ta_san_pham, duong_dan_anh, so_luong_san_pham, so_luong_ban, ngay_tao, ngay_sua) VALUES ('004', '3', '1', 'San Pham 2', 'San pham tot', 'https://mywebsite.com/sanpham1', '20', '10', '2020-08-06', '2020-08-06');
INSERT INTO san_pham (ma_san_pham, danh_muc, kho, ten, mo_ta_san_pham, duong_dan_anh, so_luong_san_pham, so_luong_ban, ngay_tao, ngay_sua) VALUES ('005', '1', '1', 'San Pham 2', 'San pham tot', 'https://mywebsite.com/sanpham1', '20', '10', '2020-08-06', '2020-08-06');
INSERT INTO san_pham (ma_san_pham, danh_muc, kho, ten, mo_ta_san_pham, duong_dan_anh, so_luong_san_pham, so_luong_ban, ngay_tao, ngay_sua) VALUES ('006', '2', '1', 'San Pham 3', 'San pham tot', 'https://mywebsite.com/sanpham1', '20', '10', '2020-08-06', '2020-08-06');
INSERT INTO san_pham (ma_san_pham, danh_muc, kho, ten, mo_ta_san_pham, duong_dan_anh, so_luong_san_pham, so_luong_ban, ngay_tao, ngay_sua) VALUES ('007', '3', '1', 'abc Điện thoại', 'San pham tot', 'https://mywebsite.com/sanpham1', '20', '10', '2020-08-06', '2020-08-06');

-- update table san_pham
UPDATE san_pham 
SET ten = 'San pham 1',
	ngay_sua = '2020-08-07'
WHERE (id = 4);

-- delete row in table san_pham
DELETE FROM san_pham
WHERE (id = 6);

-- find san pham (ten: 'Dien thoai', danh muc: 'Apple')
select sp.* from san_pham as sp, loai_danh_muc as ldm
where sp.ten like '%Điện thoại%'
and sp.danh_muc = ldm.id
and ldm.ten = 'Apple';

-- count san_pham in loai_danh_muc and sort 
select ldm.ten, sum(sp.so_luong_san_pham) as So_luong from san_pham as sp, loai_danh_muc as ldm
where sp.danh_muc = ldm.id
group by ldm.id
order by sum(sp.so_luong_san_pham) desc;

-- delete danh_muc and san_pham using transaction 
Start transaction;

/*delete from san_pham 
where (danh_muc = 2);*/

delete from loai_danh_muc
where (id = 2);

commit;

-- find 10 san_pham with most sales
DROP procedure IF EXISTS select_10_san_pham_most_sales;
DELIMITER $$
CREATE PROCEDURE select_10_san_pham_most_sales(IN num INT(11))
BEGIN
   SELECT *  FROM san_pham
   order by san_pham.so_luong_ban desc
   limit num;
END;
DELIMITER

CALL select_10_san_pham_most_sales(5);