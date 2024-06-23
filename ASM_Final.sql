Create database asm_java5
go
Use asm_java5
go
Create Table san_pham(
	idsan_pham INT PRIMARY KEY,
	ma NVARCHAR(30),
	ten NVARCHAR(30),
	trangthai BIT,
);
Create Table khach_hang(
	idkhach_hang INT PRIMARY KEY,
	ten NVARCHAR(30),
	sdt VARCHAR(30),
	makh NVARCHAR(30),
	trangthai BIT,
);
Create Table nhan_vien(
	idnhan_vien INT PRIMARY KEY,
	ten NVARCHAR(30),
	manv NVARCHAR(30),
	tendangnhap VARCHAR(30),
	matkhau VARCHAR(30),
	trangthai BIT,
);
Create Table mau_sac(
	idmau_sac INT PRIMARY KEY,
	ma NVARCHAR(30),
	ten NVARCHAR(30),
	trangthai BIT,
);
Create Table kich_thuoc(
	idkich_thuoc INT PRIMARY KEY,
	ma NVARCHAR(30),
	ten NVARCHAR(30),
	trangthai BIT,
);

Create Table spct(
	idspct INT PRIMARY KEY,
	maspct NVARCHAR(30),
	idkich_thuoc INT FOREIGN KEY REFERENCES kich_thuoc,
	idmau_sac INT FOREIGN KEY REFERENCES mau_sac,
	idsan_pham INT FOREIGN KEY REFERENCES san_pham,
	soluong INT,
	dongia INT,
	trangthai BIT,
);
Create Table hoa_don(
	idhoa_don INT PRIMARY KEY,
	idnhan_vien INT FOREIGN KEY REFERENCES nhan_vien,
	idkhach_hang INT FOREIGN KEY REFERENCES khach_hang,
	ngaymuahang DATE,
	trangthai BIT,
);
Create Table hdct(
	idhdct INT PRIMARY KEY,
	idhoa_hon INT FOREIGN KEY REFERENCES hoa_don,
	idspct INT FOREIGN KEY REFERENCES spct,
	soluong INT FOREIGN KEY REFERENCES spct,
	dongia INT FOREIGN KEY REFERENCES spct,
	trangthai BIT,
);

INSERT INTO san_pham Values
(1,'SP01','Ao Thun',1),
(2,'SP02','Ao Khoac',1),
(3,'SP03','Ao Ba Lo',0),
(4,'SP04','Quan Short',1),
(5,'SP05','Quan Dai',0)
INSERT INTO mau_sac Values
(1,'MS01','Xanh',1),
(2,'MS02','Do',1),
(3,'MS03','Tim',0),
(4,'MS04','Vang',1),
(5,'MS05','Den',0)
INSERT INTO kich_thuoc values
(1,'KT01','M',1),
(2,'KT02','L',1),
(3,'KT03','Xl',0),
(4,'KT04','XXL',1),
(5,'KT05','S',0)
INSERT INTO spct Values
(1,'SPCT01',1,1,2,10,50,1),
(2,'SPCT02',2,2,3,20,100,1),
(3,'SPCT03',4,3,1,40,110,1),
(4,'SPCT04',3,4,3,5,55,0),
(5,'SPCT05',1,1,4,10,70,1)

INSERT INTO khach_hang Values
(1,'Long','091237987','KH01',1),
(2,'Hien','0912379123','KH02',1),
(3,'TUng','0912213','KH03',1),
(4,'Nguyen','0912314','KH04',1),
(5,'Duc','091237123','KH05',1),
(6,'aBC','0912379134','KH06',1)
INSERT INTO nhan_vien Values
(1,'Nhan Vien Sang','NV01','nhanviensang','123',1),
(2,'Nhan Vien Chieu','NV02','nhanvienchieu','123',1),
(3,'Nhan Vien Toi','NV03','nhanvientoi','123',1)


Select*from KhachHang
select*from khach_hang