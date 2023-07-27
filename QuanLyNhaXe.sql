CREATE TABLE KHACHHANG
(
	MAKH CHAR(10) PRIMARY KEY,
	TENKH NVARCHAR2(200) NOT NULL,
	SDT CHAR(10) UNIQUE,
	DIACHI NVARCHAR2(200),
	ANH BLOB
)
/

CREATE TABLE CHUCVU
(
	MACV CHAR(10) PRIMARY KEY,
	TENCV NVARCHAR2(200)
)
/

CREATE TABLE NHANVIEN
(
	MANV CHAR(10) PRIMARY KEY,
	MACV CHAR(10),
	TENNV NVARCHAR2(200),
    TENDN VARCHAR(20) UNIQUE,
    PASSWORD CHAR(10),
	SDT CHAR(10) UNIQUE,
	DIACHI NVARCHAR2(200),
	ANH BLOB,
	CONSTRAINT FK_NV_CV FOREIGN KEY(MACV) REFERENCES CHUCVU(MACV)
)


CREATE TABLE TUYENXE
(
	MATUYEN CHAR(10) PRIMARY KEY,
	TENTUYEN NVARCHAR2(200)
)
/
ALTER TABLE TUYENXE ADD (BENXEDI NVARCHAR2(200), BENXEDEN NVARCHAR2(200));

CREATE TABLE XE
(
	MAXE CHAR(10) PRIMARY KEY,
	MANV CHAR(10),
	TENXE NVARCHAR2(200),
	BIENSO CHAR(10),
	ANH BLOB,
	CONSTRAINT FK_XE_TX FOREIGN KEY(MANV) REFERENCES NHANVIEN(MANV)
)
/

CREATE TABLE CHUYENXE
(
	MACHUYEN CHAR(10) PRIMARY KEY,
	TENCHUYEN NVARCHAR2(200),
	MATUYEN CHAR(10),
	MAXE CHAR(10),
	GIOXP CHAR(5),
	CONSTRAINT FK_CX_TX FOREIGN KEY(MATUYEN) REFERENCES TUYENXE(MATUYEN),
	CONSTRAINT FK_CX_MX FOREIGN KEY(MAXE) REFERENCES XE(MAXE)
)
/

CREATE TABLE VEXE
(
	MAVE CHAR(10) PRIMARY KEY,    
	MAKH CHAR(10),
	MANV CHAR(10),
	MACHUYEN CHAR(10),
	NGAYDI DATE,
	VITRI CHAR(4),
    GIAVE FLOAT,
	CONSTRAINT FK_VX_NV FOREIGN KEY(MANV) REFERENCES NHANVIEN (MANV),
	CONSTRAINT FK_VX_KH FOREIGN KEY(MAKH) REFERENCES KHACHHANG(MAKH),
	CONSTRAINT FK_VX_MC FOREIGN KEY(MACHUYEN) REFERENCES CHUYENXE(MACHUYEN)
)
/


set SERVEROUTPUT ON;
declare
    l_bfile BFILE;
    l_blob BLOB;
    l_dest_offset integer :=1;
    l_src_offset integer :=1;
    l_lobmaxsize constant integer := DBMS_LOB.LOBMAXSIZE;
begin
    UPDATE  KHACHHANG SET TENKH= N'Tr??ng Gia Hân',DIACHI=N'30 Cô Giang',SDT='093292392', ANH =empty_blob()
    WHERE MAKH = 'KH021'
    return ANH into l_blob;
    
    l_bfile := bfilename('QLNX_DIREC','vanminh.jpg');
    DBMS_LOB.fileopen(l_bfile, DBMS_LOB.file_readonly);
    DBMS_LOB.loadblobfromfile (l_blob, l_bfile, l_lobmaxsize, l_dest_offset, l_src_offset);
    DBMS_LOB.fileclose(l_bfile);
    DBMS_oUTPUT.PUT_LINE('Size of the Image is: '|| dbms_lob.getlength(l_blob));
    commit;
end;
select anh from khachhang where = 'KH01';
update khachhang set tenkh, diachi where makh = 'KH01';
select * from khachhang where TENKH = N'Hoàng Nam Ti?n';
/----------------------------/
INSERT INTO CHUCVU(MACV,TENCV)
VALUES('NV', N'Nhân Viên');
INSERT INTO CHUCVU(MACV,TENCV)
VALUES('TX', N'Tài X?');
select * from CHUCVU
/---------------------------/
set SERVEROUTPUT ON;
declare
    l_bfile BFILE;
    l_blob BLOB;
    l_dest_offset integer :=1;
    l_src_offset integer :=1;
    l_lobmaxsize constant integer := DBMS_LOB.LOBMAXSIZE;
begin
    INSERT INTO NHANVIEN(MACV, TENDN,PASSWORD,TENNV, SDT, DIACHI, ANH)
    VALUES ('TX','vanminh','minh123',N'Nguy?n V?n Minh', '079219911', N'20 Cô Giang',empty_blob())
    return ANH into l_blob;
    
    l_bfile := bfilename('QLNX_DIREC','vanminh.jpg');
    DBMS_LOB.fileopen(l_bfile, DBMS_LOB.file_readonly);
    DBMS_LOB.loadblobfromfile (l_blob, l_bfile, l_lobmaxsize, l_dest_offset, l_src_offset);
    DBMS_LOB.fileclose(l_bfile);
    DBMS_oUTPUT.PUT_LINE('Size of the Image is: '|| dbms_lob.getlength(l_blob));
    commit;
end;
select * from nhanvien

select * from chucvu

select * from nhanvien where tendn = 'phatnguyen' and password = 'ptn123'
/--------------------------------------/
INSERT INTO TUYENXE VALUES('SGHN', N'Sài Gòn - Hà N?i');
INSERT INTO TUYENXE VALUES('SGNT', N'Sài Gòn - Nha Trang'); 
INSERT INTO TUYENXE VALUES('SGAG', N'Sài Gòn - An Giang'); 
select * from TUYENXE
/------------------------------------------/
declare
    l_bfile BFILE;
    l_blob BLOB;
    l_dest_offset integer :=1;
    l_src_offset integer :=1;
    l_lobmaxsize constant integer := DBMS_LOB.LOBMAXSIZE;
begin
    INSERT INTO XE(MANV, TENXE, BIENSO, ANH)
    VALUES ((select manv from nhanvien where tennv = N'Nguyên Chân' and MACV ='TX'),N'Trà Lan Viên','51S-001.2',empty_blob())
    return ANH into l_blob;  
    l_bfile := bfilename('QLNX_DIREC','tralanvien.jpg');
    DBMS_LOB.fileopen(l_bfile, DBMS_LOB.file_readonly);
    DBMS_LOB.loadblobfromfile (l_blob, l_bfile, l_lobmaxsize, l_dest_offset, l_src_offset);
    DBMS_LOB.fileclose(l_bfile);
    DBMS_oUTPUT.PUT_LINE('Size of the Image is: '|| dbms_lob.getlength(l_blob));
    commit;
end;
select * from nhanvien
select * from khachhang
update xe set manv = 'TX04' where maxe
select * from chuyenxe where gioxp = '16h'
select * from tuyenxe
select * from chuyenxe
select * from xe
/----------------------------------------------------------/

INSERT INTO CHUYENXE VALUES('SGHN16H', N'Sài Gòn - Hà N?i 16h', 'SGHN', 'XE035', '16h');
INSERT INTO CHUYENXE VALUES('SGNT22H', N'Sài Gòn - Nha Trang 22h', 'SGNT', 'XE032', '22h');
INSERT INTO CHUYENXE VALUES('SGAG17H', N'Sài Gòn - An Giang 17h', 'SGAG', 'XE033', '17h');



update chuyenxe set matuyen ='SGBT' where machuyen ='SGBT10H'
UPDATE CHUYENXE SET TENCHUYEN = N'Sài Gòn - Hue 5h', MATUYEN = (select matuyen from tuyenxe where tentuyen = N'Sài Gòn - Hue')
MAXE = (select maxe from xe where bienso ='51S-0999'), GIOXP = '5h' WHERE MACHUYEN = 'SGH20H';
select manv from nhanvien where tendn = 'phatnguyen'
select makh from khachhang where tenkh = N'Hoàng Nam Ti?n';
select machuyen from chuyenxe where tenchuyen = N'Sài Gòn - Hà N?i 16h'
UPDATE CHUYENXE 
SET TENCHUYEN = N'Sài Gòn - Hà N?i 20h', 
    MATUYEN = (select matuyen from tuyenxe where tentuyen = N'Sài Gòn - Hà N?i'),
    MAXE = (select maxe from xe where bienso ='51S-0999'), 
    GIOXP = '20h' 
WHERE MACHUYEN = 'SGHN20H'
delete vexe where mave = 'VX06'
select * from vexe
select * from nhanvien
update nhanvien set manv = 'NV07' where manv = 'TX07'
INSERT INTO VEXE(MAKH, MANV, MACHUYEN, NGAYDI, VITRI, GIAVE)
VALUES('KH021', 'NV01', 'SGHN16H', TO_DATE('02-05-2023', 'DD-MM-YYYY'), 'A2', '300000')
INSERT INTO VEXE(MAKH, MANV, MACHUYEN, NGAYDI, VITRI, GIAVE)
VALUES('KH029', 'NV21', 'SGNT22H', TO_DATE('03-05-2023', 'DD-MM-YYYY'), 'B1', '200000')
INSERT INTO VEXE(MAKH, MANV, MACHUYEN, NGAYDI, VITRI, GIAVE)
VALUES('KH02', 'NV01', 'SGNT22H', TO_DATE('03-05-2023', 'DD-MM-YYYY'), 'C1', 5000)

 SELECT VX.MAVE,KH.TENKH, NV.TENNV, CX.TENCHUYEN, VX.NGAYDI, VX.VITRI,VX.GIAVE
                         FROM VEXE VX
                         INNER JOIN NHANVIEN NV ON VX.MANV = NV.MANV
                         INNER JOIN CHUYENXE CX ON VX.MACHUYEN = CX.MACHUYEN
                         INNER JOIN KHACHHANG KH ON VX.MAKH = KH.MAKH
                         
SELECT VX.MAVE, KH.TENKH, NV.TENNV, CX.TENCHUYEN, VX.NGAYDI, VX.VITRI, VX.GIAVE
FROM VEXE VX
INNER JOIN NHANVIEN NV ON VX.MANV = NV.MANV
INNER JOIN CHUYENXE CX ON VX.MACHUYEN = CX.MACHUYEN
INNER JOIN KHACHHANG KH ON VX.MAKH = KH.MAKH
WHERE VX.MAVE = 'VX09'



                       
                         
 INSERT INTO VEXE(MAKH, MANV, MACHUYEN, NGAYDI, VITRI, GIAVE)
VALUES((SELECT makh FROM khachhang WHERE tenkh = N'Hoàng Nam Ti?n'),
       (SELECT manv FROM nhanvien WHERE tendn ='phatnguyen'), 
       (SELECT machuyen FROM chuyenxe WHERE tenchuyen = N'Sài Gòn - An Giang 17h'),
       TO_DATE('05-05-2023', 'DD-MM-YYYY'), 'C1', '400000')

SELECT VX.MAVE, KH.TENKH, NV.TENNV, CX.TENCHUYEN, TO_CHAR(VX.NGAYDI, 'DD-MM-YYYY') AS NGAYDI, VX.VITRI, VX.GIAVE
FROM VEXE VX
INNER JOIN NHANVIEN NV ON VX.MANV = NV.MANV
INNER JOIN CHUYENXE CX ON VX.MACHUYEN = CX.MACHUYEN
INNER JOIN KHACHHANG KH ON VX.MAKH = KH.MAKH WHERE VX.MAVE = 'VX05'

select * from tuyenxe
select * from nhanvien
update tuyenxe set benxeden = N'B?n Xe Phía Nam TP.Nha Trang' where matuyen = 'SGNT'
SELECT VX.MAVE, KH.TENKH, NV.TENNV, CX.TENCHUYEN, TO_CHAR(VX.NGAYDI, 'DD-MM-YYYY') AS NGAYDI, VX.VITRI, VX.GIAVE
FROM VEXE VX
INNER JOIN NHANVIEN NV ON VX.MANV = NV.MANV
INNER JOIN CHUYENXE CX ON VX.MACHUYEN = CX.MACHUYEN
INNER JOIN KHACHHANG KH ON VX.MAKH = KH.MAKH WHERE VX.MAVE = 'VX08'

select * from vexe

SELECT SUM(GIAVE) 
FROM VEXE;

SELECT VX.MAVE, KH.TENKH, TO_CHAR(VX.NGAYDI, 'MM-YYYY') AS THANG, VX.VITRI, CX.TENCHUYEN, VX.GIAVE,
FROM VEXE VX
JOIN KHACHHANG KH ON VX.MAKH = KH.MAKH
JOIN CHUYENXE CX ON VX.MACHUYEN = CX.MACHUYEN WHERE 


SELECT TO_CHAR(VX.NGAYDI, 'MM-YYYY') AS THANG, SUM(VX.GIAVE) AS TONGVE FROM VEXE VX GROUP BY TO_CHAR(VX.NGAYDI, 'MM-YYYY');

