CREATE TABLE kho (
  id INT NOT NULL AUTO_INCREMENT,
  ma_kho VARCHAR(10) NULL,
  ten NVARCHAR(50) NULL,
  dia_diem NVARCHAR(100) NULL,
  ngay_tao DATE NULL,
  ngay_sua DATE NULL,
  PRIMARY KEY (id)
  );
  
create table loai_danh_muc (
	id INT NOT NULL auto_increment,
    ma_loai_danh_muc varchar(10) null,
    ten nvarchar(50) null,
    mo_ta text null,
    ngay_tao date null,
    ngay_sua date null,
    primary key (id)
);

create table san_pham (
	id int not null auto_increment,
    ma_san_pham varchar(10) null,
    danh_muc int not null,
    kho int not null,
    ten nvarchar(50) null,
    mo_ta_san_pham text null,
    duong_dan_anh nvarchar(100) null,
    so_luong_san_pham int null,
    so_luong_ban int null,
    ngay_tao date null,
    ngay_sua date null,
    primary key (id),
    constraint PK_SanPham_LoaiDanhMuc foreign key (danh_muc) references loai_danh_muc(id) on update cascade on delete cascade,
    constraint PK_SanPham_Kho foreign key (kho) references kho(id) on update cascade on delete cascade
)
