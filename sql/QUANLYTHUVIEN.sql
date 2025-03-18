CREATE DATABASE QUANLYTHUVIEN;
GO
USE QUANLYTHUVIEN;

CREATE TABLE LOGIN (
    TENTAIKHOAN VARCHAR(30) PRIMARY KEY,
    MATKHAU NVARCHAR(30)
);

-- Truy vấn sửa mật khẩu
CREATE PROCEDURE changerpass
    @TENTAIKHOAN VARCHAR(30),
    @MATKHAU NVARCHAR(30)
AS
BEGIN
    UPDATE LOGIN
    SET MATKHAU = @MATKHAU
    WHERE TENTAIKHOAN = @TENTAIKHOAN;
END;

CREATE TABLE DOCGIA (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    TENSV NVARCHAR(30),
    MASV NVARCHAR(30) UNIQUE,
    NGAYSINH NVARCHAR(30),
    SDT NVARCHAR(30),
    GIOITINH NVARCHAR(30),
    DIACHI NVARCHAR(30),
    LOP NVARCHAR(30),
    KHOA NVARCHAR(30),
    NGANH NVARCHAR(30),
    GMAIL NVARCHAR(50)
);

-- Tạo thủ tục InsertDocGia
CREATE PROCEDURE InsertDocGia
    @TENSV NVARCHAR(30),
    @MASV NVARCHAR(30),
    @NGAYSINH NVARCHAR(30),
    @SDT NVARCHAR(30),
    @GIOITINH NVARCHAR(30),
    @DIACHI NVARCHAR(30),
    @LOP NVARCHAR(30),
    @KHOA NVARCHAR(30),
    @NGANH NVARCHAR(30),
    @GMAIL NVARCHAR(50)
AS
BEGIN
    -- Kiểm tra xem mã sinh viên đã tồn tại chưa
    IF NOT EXISTS (SELECT 1 FROM DOCGIA WHERE MASV = @MASV)
    BEGIN
        INSERT INTO DOCGIA (TENSV, MASV, NGAYSINH, SDT, GIOITINH, DIACHI, LOP, KHOA, NGANH, GMAIL)
        VALUES (@TENSV, @MASV, @NGAYSINH, @SDT, @GIOITINH, @DIACHI, @LOP, @KHOA, @NGANH, @GMAIL);
    END;
END;

-- Tạo thủ tục tìm kiếm

	CREATE PROCEDURE TimKiemDocGia
    @Keyword NVARCHAR(50)
AS
BEGIN
    SELECT *
    FROM DOCGIA
    WHERE TENSV LIKE '%' + @Keyword + '%'
       OR MASV LIKE '%' + @Keyword + '%'
       OR SDT LIKE '%' + @Keyword + '%'
       OR LOP LIKE '%' + @Keyword + '%'
       OR NGANH LIKE '%' + @Keyword + '%'
END;
EXEC TimKiemDocGia @Keyword = 't';



-- Tạo bảng SÁCH
CREATE TABLE SACH (
    MASACH NVARCHAR(30) PRIMARY KEY,
    TENSACH NVARCHAR(30),
    SOLUONG INT,
    THELOAI NVARCHAR(30),
    TACGIA NVARCHAR(30),
    NHAXUATBAN NVARCHAR(30),
    NAMXUATBAN INT
);

-- Thủ tục thêm sách
CREATE PROCEDURE THEMSACH
    @MASACH NVARCHAR(30),
    @TENSACH NVARCHAR(30),
    @SOLUONG INT,
    @THELOAI NVARCHAR(30),
    @TACGIA NVARCHAR(30),
    @NHAXUATBAN NVARCHAR(30),
    @NAMXUATBAN INT
AS
BEGIN
    INSERT INTO SACH (MASACH, TENSACH, SOLUONG, THELOAI, TACGIA, NHAXUATBAN, NAMXUATBAN)
    VALUES (@MASACH, @TENSACH, @SOLUONG, @THELOAI, @TACGIA, @NHAXUATBAN, @NAMXUATBAN);
END;

--tìm kiếm sách
	CREATE PROCEDURE Timsach
		@Keyword NVARCHAR(50)
	AS
	BEGIN
		SELECT *
		FROM SACH
		WHERE MASACH LIKE '%' + @Keyword + '%'
		   OR TENSACH LIKE '%' + @Keyword + '%'
		   OR THELOAI LIKE '%' + @Keyword + '%'
		   OR TACGIA LIKE '%' + @Keyword + '%'
		   OR NHAXUATBAN LIKE '%' + @Keyword + '%'
	END;

EXEC Timsach @Keyword = 'SK002';





-- Tạo bảng MƯỢN TRẢ với các khóa ngoại
CREATE TABLE MUONTRA (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    MAMUON NVARCHAR(30) UNIQUE,
    MASV NVARCHAR(30),
    GMAIL NVARCHAR(30),
    TENSACH NVARCHAR(30),
    MASACH NVARCHAR(30),
    NGAYMUON NVARCHAR(30),
    NGAYTRA NVARCHAR(30),
    SOLUONG INT,
    TINHTRANG NVARCHAR(30),
    GHICHU NVARCHAR(30),
    FOREIGN KEY (MASV) REFERENCES DOCGIA (MASV),
    FOREIGN KEY (MASACH) REFERENCES SACH (MASACH)
);

-- Thủ tục thêm dữ liệu vào bảng MƯỢN TRẢ
CREATE PROCEDURE THEMMUONTRA
    @MAMUON NVARCHAR(30),
    @MASV NVARCHAR(30),
    @GMAIL NVARCHAR(30),
    @TENSACH NVARCHAR(30),
    @MASACH NVARCHAR(30),
    @NGAYMUON NVARCHAR(30),
    @NGAYTRA NVARCHAR(30),
    @SOLUONG INT,
    @TINHTRANG NVARCHAR(30),
    @GHICHU NVARCHAR(30)
AS
BEGIN
    INSERT INTO MUONTRA (MAMUON, MASV, GMAIL, TENSACH, MASACH, NGAYMUON, NGAYTRA, SOLUONG, TINHTRANG, GHICHU)
    VALUES (@MAMUON, @MASV, @GMAIL, @TENSACH, @MASACH, @NGAYMUON, @NGAYTRA, @SOLUONG, @TINHTRANG, @GHICHU);
END;



--tìm kiếm sách
	CREATE PROCEDURE Timmuontra
		@Keyword NVARCHAR(50)
	AS
	BEGIN
		SELECT *
		FROM MUONTRA
		WHERE MAMUON LIKE '%' + @Keyword + '%'
		   OR MASV LIKE '%' + @Keyword + '%'
		   OR TINHTRANG LIKE '%' + @Keyword + '%'
		   OR GMAIL LIKE '%' + @Keyword + '%'
		   OR MASACH LIKE '%' + @Keyword + '%'
	END;

EXEC Timmuontra @Keyword = 'SK002';


-- tạo bảng lịch sử  thông báo
CREATE TABLE HISTORY (
ID INT IDENTITY(1,1) PRIMARY KEY,
    GMAIL NVARCHAR(50) ,
    TIEUDE NVARCHAR(100),
    NOIDUNG NVARCHAR(1000),
);




CREATE PROCEDURE THEMHISTORY
    @GMAIL NVARCHAR(30),
    @TIEUDE NVARCHAR(30),
    @NOIDUNG NVARCHAR(30)
AS
BEGIN
    INSERT INTO HISTORY (GMAIL, TIEUDE, NOIDUNG)
    VALUES (@GMAIL, @TIEUDE, @NOIDUNG);
END;

-- Thêm dữ liệu vào bảng LOGIN
INSERT INTO LOGIN (TENTAIKHOAN, MATKHAU) VALUES ('admin', 'admin');

-- Thêm dữ liệu vào bảng SACH
EXEC THEMSACH @MASACH = N'SK002', @TENSACH = N'Toán Học Đại Cương', @SOLUONG = 15, @THELOAI = N'Toán học', @TACGIA = N'Nguyễn Thị B', @NHAXUATBAN = N'XYZ Books', @NAMXUATBAN = 2019;
EXEC THEMSACH @MASACH = N'SK003', @TENSACH = N'Lịch Sử Thế Giới', @SOLUONG = 25, @THELOAI = N'Lịch sử', @TACGIA = N'Trần Văn C', @NHAXUATBAN = N'History Press', @NAMXUATBAN = 2021;
EXEC THEMSACH @MASACH = N'SK004', @TENSACH = N'The Catcher in the Rye', @SOLUONG = 30, @THELOAI = N'Tiểu thuyết', @TACGIA = N'J.D. Salinger', @NHAXUATBAN = N'Little, Brown and Company', @NAMXUATBAN = 1951;
EXEC THEMSACH @MASACH = N'SK006', @TENSACH = N'Introduction to Machine Learning with Python', @SOLUONG = 25, @THELOAI = N'Công nghệ và khoa học ứng dụng', @TACGIA = N'Andreas C. Müller, Sarah Guido', @NHAXUATBAN = N'Reilly Media', @NAMXUATBAN = 2016;
EXEC THEMSACH @MASACH = N'SK008', @TENSACH = N'Ứng Dụng Công Nghệ Thông Tin trong Doanh Nghiệp Việt Nam', @SOLUONG = 30, @THELOAI = N'Công nghệ và khoa học ứng dụng', @TACGIA = N'Nguyễn Thị C', @NHAXUATBAN = N'NXB Khoa Học và Kỹ Thuật Việt Nam', @NAMXUATBAN = 2019;
EXEC THEMSACH @MASACH = N'SK009', @TENSACH = N'Trận Chiến Điện Biên Phủ', @SOLUONG = 20, @THELOAI = N'Lịch sử', @TACGIA = N'Phan Đình Phùng', @NHAXUATBAN = N'NXB Lịch Sử', @NAMXUATBAN = 2005;
EXEC THEMSACH @MASACH = N'SK010', @TENSACH = N'The Theory of Everything', @SOLUONG = 25, @THELOAI = N'Khoa học', @TACGIA = N'Stephen Hawking', @NHAXUATBAN = N'NXB Science', @NAMXUATBAN = 2003;
EXEC THEMSACH @MASACH = N'SK011', @TENSACH = N'Beyond Infinity: An Expedition to the Outer Limits of Mathematics', @SOLUONG = 15, @THELOAI = N'Toán học', @TACGIA = N'Eugenia Cheng', @NHAXUATBAN = N'NXB Math', @NAMXUATBAN = 2017;
EXEC THEMSACH @MASACH = N'SK012', @TENSACH = N'One Piece Vol. 100', @SOLUONG = 30, @THELOAI = N'Truyện tranh', @TACGIA = N'Eiichiro Oda', @NHAXUATBAN = N'NXB Manga', @NAMXUATBAN = 2021;
EXEC THEMSACH @MASACH = N'SK013', @TENSACH = N'The Bible', @SOLUONG = 50, @THELOAI = N'Tôn giáo', @TACGIA = N'Various Authors', @NHAXUATBAN = N'NXB Religious', @NAMXUATBAN = 1611;
EXEC THEMSACH @MASACH = N'SK014', @TENSACH = N'The Communist Manifesto', @SOLUONG = 40, @THELOAI = N'Chính trị và xã hội', @TACGIA = N'Karl Marx', @NHAXUATBAN = N'NXB Politics', @NAMXUATBAN = 1848;
EXEC THEMSACH @MASACH = N'SK015', @TENSACH = N'Beethoven: The Music and the Life', @SOLUONG = 20, @THELOAI = N'Âm nhạc', @TACGIA = N'Lewis Lockwood', @NHAXUATBAN = N'NXB Music', @NAMXUATBAN = 2003;
EXEC THEMSACH @MASACH = N'SK016', @TENSACH = N'The History of Art', @SOLUONG = 25, @THELOAI = N'Nghệ thuật và hội họa', @TACGIA = N'Ernst Gombrich', @NHAXUATBAN = N'NXB Art', @NAMXUATBAN = 1950;
EXEC THEMSACH @MASACH = N'SK017', @TENSACH = N'The Lean Startup', @SOLUONG = 30, @THELOAI = N'Kinh doanh và tài chính', @TACGIA = N'Eric Ries', @NHAXUATBAN = N'NXB Business', @NAMXUATBAN = 2011;
EXEC THEMSACH @MASACH = N'SK018', @TENSACH = N'Introduction to Artificial Intelligence', @SOLUONG = 15, @THELOAI = N'Kỹ thuật và công nghệ', @TACGIA = N'Sebastian Thrun', @NHAXUATBAN = N'NXB Tech', @NAMXUATBAN = 2020;




-- Thêm dữ liệu vào bảng DOCGIA
EXEC InsertDocGia @TENSV = N'Nguyễn Minh B', @MASV = '20210665', @NGAYSINH = '18/09/2003', @SDT = '032549723', @GIOITINH = N'Nam', @DIACHI = N'Hà Nội', @LOP = N'CNTT2', @KHOA = N'K12', @NGANH = N'Công Nghệ Thông Tin', @GMAIL = N'20210665@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Nguyễn Văn A', @MASV = '20210001', @NGAYSINH = '01/01/1999', @SDT = '0123456789', @GIOITINH = N'Nam', @DIACHI = N'Hà Nội', @LOP = N'CNTT1', @KHOA = N'K11', @NGANH = N'Công Nghệ Thông Tin', @GMAIL = N'20210001@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Trần Thị B', @MASV = '20210002', @NGAYSINH = '15/05/2000', @SDT = '0987654321', @GIOITINH = N'Nữ', @DIACHI = N'Đà Nẵng', @LOP = N'CNTT3', @KHOA = N'K13', @NGANH = N'Công Nghệ Thông Tin', @GMAIL = N'20210002@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Nguyễn Thị Hằng', @MASV = '20210011', @NGAYSINH = '05/03/2000', @SDT = '0987654321', @GIOITINH = N'Nữ', @DIACHI = N'Hà Nội', @LOP = N'CNTT1', @KHOA = N'K11', @NGANH = N'Công Nghệ Thông Tin', @GMAIL = N'20210011@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Trần Văn Hoàng', @MASV = '20210012', @NGAYSINH = '10/10/1999', @SDT = '0978123456', @GIOITINH = N'Nam', @DIACHI = N'Hồ Chí Minh', @LOP = N'CNTT2', @KHOA = N'K12', @NGANH = N'Công Nghệ Thông Tin', @GMAIL = N'20210012@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Trần Thị Hằng', @MASV = '20210013', @NGAYSINH = '15/02/2000', @SDT = '0987654321', @GIOITINH = N'Nữ', @DIACHI = N'Hà Nội', @LOP = N'CNTT1', @KHOA = N'K13', @NGANH = N'Công Nghệ Phần Mềm', @GMAIL = N'20210013@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Nguyễn Văn A', @MASV = '20210014', @NGAYSINH = '05/03/1998', @SDT = '0978123456', @GIOITINH = N'Nam', @DIACHI = N'Hồ Chí Minh', @LOP = N'CNTT2', @KHOA = N'K14', @NGANH = N'Hệ Thống Thông Tin', @GMAIL = N'20210014@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Lê Thị Bích Ngọc', @MASV = '20210015', @NGAYSINH = '20/11/2001', @SDT = '0909123456', @GIOITINH = N'Nữ', @DIACHI = N'Hải Phòng', @LOP = N'CNTT1', @KHOA = N'K15', @NGANH = N'Mạng và Truyền Thông', @GMAIL = N'20210015@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Phạm Văn Cường', @MASV = '20210016', @NGAYSINH = '25/09/1999', @SDT = '0934123456', @GIOITINH = N'Nam', @DIACHI = N'Đà Nẵng', @LOP = N'CNTT2', @KHOA = N'K16', @NGANH = N'An Toàn Thông Tin', @GMAIL = N'20210016@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Hoàng Thị Lan Anh', @MASV = '20210017', @NGAYSINH = '07/12/2000', @SDT = '0918234567', @GIOITINH = N'Nữ', @DIACHI = N'Hà Nội', @LOP = N'CNTT1', @KHOA = N'K17', @NGANH = N'Công Nghệ Web', @GMAIL = N'20210017@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Đặng Minh Tuấn', @MASV = '20210018', @NGAYSINH = '30/06/1997', @SDT = '0945123456', @GIOITINH = N'Nam', @DIACHI = N'Thái Nguyên', @LOP = N'CNTT2', @KHOA = N'K18', @NGANH = N'Khoa Học Dữ Liệu', @GMAIL = N'20210018@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Vũ Thị Quỳnh Anh', @MASV = '20210019', @NGAYSINH = '22/08/2000', @SDT = '0967123456', @GIOITINH = N'Nữ', @DIACHI = N'Hà Nam', @LOP = N'CNTT1', @KHOA = N'K19', @NGANH = N'Quản Trị Mạng', @GMAIL = N'20210019@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Nguyễn Đình Thiên', @MASV = '20210020', @NGAYSINH = '03/04/1999', @SDT = '0978123456', @GIOITINH = N'Nam', @DIACHI = N'Hồ Chí Minh', @LOP = N'CNTT2', @KHOA = N'K20', @NGANH = N'Khoa Học Dữ Liệu', @GMAIL = N'20210020@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Trần Thị Ngọc Trâm', @MASV = '20210021', @NGAYSINH = '17/09/2001', @SDT = '0989123456', @GIOITINH = N'Nữ', @DIACHI = N'Quảng Ninh', @LOP = N'CNTT1', @KHOA = N'K21', @NGANH = N'Công Nghệ Web', @GMAIL = N'20210021@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Nguyễn Thị Linh', @MASV = '20210023', @NGAYSINH = '05/08/1999', @SDT = '0938123456', @GIOITINH = N'Nữ', @DIACHI = N'Hồ Chí Minh', @LOP = N'CNTT1', @KHOA = N'K23', @NGANH = N'Công Nghệ Thông Tin', @GMAIL = N'20210023@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Lê Văn Quang', @MASV = '20210024', @NGAYSINH = '10/12/2000', @SDT = '0978123456', @GIOITINH = N'Nam', @DIACHI = N'Hà Nội', @LOP = N'QTKD1', @KHOA = N'K24', @NGANH = N'Quản Trị Kinh Doanh', @GMAIL = N'20210024@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Phạm Thị Mai', @MASV = '20210025', @NGAYSINH = '20/03/1998', @SDT = '0945123456', @GIOITINH = N'Nữ', @DIACHI = N'Hồ Chí Minh', @LOP = N'CNO1', @KHOA = N'K25', @NGANH = N'Công Nghệ Ôtô', @GMAIL = N'20210025@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Nguyễn Văn Bình', @MASV = '20210026', @NGAYSINH = '15/09/1999', @SDT = '0989123456', @GIOITINH = N'Nam', @DIACHI = N'Hồ Chí Minh', @LOP = N'TDH1', @KHOA = N'K26', @NGANH = N'Tự Động Hóa', @GMAIL = N'20210026@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Lê Thị Thúy', @MASV = '20210027', @NGAYSINH = '25/05/2001', @SDT = '0967123456', @GIOITINH = N'Nữ', @DIACHI = N'Đà Nẵng', @LOP = N'QTKS1', @KHOA = N'K27', @NGANH = N'Quản Trị Khách Sạn', @GMAIL = N'20210027@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Trần Văn Tuấn', @MASV = '20210028', @NGAYSINH = '03/11/2000', @SDT = '0918234567', @GIOITINH = N'Nam', @DIACHI = N'Hồ Chí Minh', @LOP = N'CNTT2', @KHOA = N'K28', @NGANH = N'Công Nghệ Thông Tin', @GMAIL = N'20210028@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Nguyễn Thị Ngọc', @MASV = '20210029', @NGAYSINH = '12/07/1998', @SDT = '0936123456', @GIOITINH = N'Nữ', @DIACHI = N'Hà Nội', @LOP = N'QTKD2', @KHOA = N'K29', @NGANH = N'Quản Trị Kinh Doanh', @GMAIL = N'20210029@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Hoàng Văn Hùng', @MASV = '20210030', @NGAYSINH = '18/04/1999', @SDT = '0976123456', @GIOITINH = N'Nam', @DIACHI = N'Hồ Chí Minh', @LOP = N'CNO2', @KHOA = N'K30', @NGANH = N'Công Nghệ Ôtô', @GMAIL = N'20210030@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Nguyễn Thị Lan', @MASV = '20210041', @NGAYSINH = '05/08/2000', @SDT = '0938123456', @GIOITINH = N'Nữ', @DIACHI = N'Hồ Chí Minh', @LOP = N'QTKD1', @KHOA = N'K41', @NGANH = N'Quản Trị Kinh Doanh', @GMAIL = N'20210041@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Lê Văn Minh', @MASV = '20210042', @NGAYSINH = '10/12/1999', @SDT = '0978123456', @GIOITINH = N'Nam', @DIACHI = N'Hà Nội', @LOP = N'CNO1', @KHOA = N'K42', @NGANH = N'Công Nghệ Ôtô', @GMAIL = N'20210042@eaut.edu.vn';
EXEC InsertDocGia @TENSV = N'Phạm Thị Ngọc', @MASV = '20210043', @NGAYSINH = '20/11/2001', @SDT = '0909123456', @GIOITINH = N'Nữ', @DIACHI = N'Hải Phòng', @LOP = N'TDH1', @KHOA = N'K43', @NGANH = N'Tự Động Hóa', @GMAIL = N'20210043@eaut.edu.vn';

-- Thêm dữ liệu vào bảng MUONTRA
EXEC THEMMUONTRA @MAMUON = N'MUON001', @MASV = N'20210665', @GMAIL = N'20210665@eaut.edu.vn', @TENSACH = N'Toán Học Đại Cương', @MASACH = N'SK002', @NGAYMUON = N'30/09/2023', @NGAYTRA = N'20/10/2023', @SOLUONG = 1, @TINHTRANG = N'Mới', @GHICHU = N'';
EXEC THEMMUONTRA @MAMUON = N'MUON002', @MASV = N'20210665', @GMAIL = N'20210664@eaut.edu.vn', @TENSACH = N'Toán Học Đại Cương', @MASACH = N'SK002', @NGAYMUON = N'30/09/2023', @NGAYTRA = N'20/10/2023', @SOLUONG = 1, @TINHTRANG= N'Cũ', @GHICHU = N'';
EXEC THEMMUONTRA @MAMUON = N'MUON003', @MASV = N'20210665', @GMAIL = N'20210665@eaut.edu.vn', @TENSACH = N'The Catcher in the Rye', @MASACH = N'SK004', @NGAYMUON = N'01/10/2023', @NGAYTRA = N'21/10/2023', @SOLUONG = 1, @TINHTRANG = N'Mới', @GHICHU = N'';
EXEC THEMMUONTRA @MAMUON = N'MUON004', @MASV = N'20210002', @GMAIL = N'20210002@eaut.edu.vn', @TENSACH = N'The Communist Manifesto', @MASACH = N'SK014', @NGAYMUON = N'02/10/2023', @NGAYTRA = N'22/10/2023', @SOLUONG = 1, @TINHTRANG = N'Mới', @GHICHU = N'';
EXEC THEMMUONTRA @MAMUON = N'MUON005', @MASV = N'20210015', @GMAIL = N'20210015@eaut.edu.vn', @TENSACH = N'The Lean Startup', @MASACH = N'SK017', @NGAYMUON = N'03/10/2023', @NGAYTRA = N'23/10/2023', @SOLUONG = 1, @TINHTRANG = N'Mới', @GHICHU = N'';
EXEC THEMMUONTRA @MAMUON = N'MUON006', @MASV = N'20210020', @GMAIL = N'20210020@eaut.edu.vn', @TENSACH = N'The Theory of Everything', @MASACH = N'SK010', @NGAYMUON = N'04/10/2023', @NGAYTRA = N'24/10/2023', @SOLUONG = 1, @TINHTRANG = N'Mới', @GHICHU = N'';
EXEC THEMMUONTRA @MAMUON = N'MUON007', @MASV = N'20210026', @GMAIL = N'20210026@eaut.edu.vn', @TENSACH = N'Ứng Dụng Công Nghệ Thông Tin trong Doanh Nghiệp Việt Nam', @MASACH = N'SK008', @NGAYMUON = N'05/10/2023', @NGAYTRA = N'25/10/2023', @SOLUONG = 1, @TINHTRANG = N'Mới', @GHICHU = N'';
EXEC THEMMUONTRA @MAMUON = N'MUON008', @MASV = N'20210029', @GMAIL = N'20210029@eaut.edu.vn', @TENSACH = N'Trận Chiến Điện Biên Phủ', @MASACH = N'SK009', @NGAYMUON = N'06/10/2023', @NGAYTRA = N'26/10/2023', @SOLUONG = 1, @TINHTRANG= N'Mới', @GHICHU = N'';
EXEC THEMMUONTRA @MAMUON = N'MUON009', @MASV = N'20210030', @GMAIL = N'20210030@eaut.edu.vn', @TENSACH = N'The History of Art', @MASACH = N'SK016', @NGAYMUON = N'07/10/2023', @NGAYTRA = N'27/10/2023', @SOLUONG = 1, @TINHTRANG = N'Mới', @GHICHU = N'';
EXEC THEMMUONTRA @MAMUON = N'MUON010', @MASV = N'20210043', @GMAIL = N'20210043@eaut.edu.vn', @TENSACH = N'Introduction to Artificial Intelligence', @MASACH = N'SK018', @NGAYMUON = N'08/10/2023', @NGAYTRA = N'28/10/2023', @SOLUONG = 1, @TINHTRANG = N'Mới', @GHICHU = N'';
EXEC THEMMUONTRA @MAMUON = N'MUON011', @MASV = N'20210024', @GMAIL = N'20210024@eaut.edu.vn', @TENSACH = N'Beethoven: The Music and the Life', @MASACH = N'SK015', @NGAYMUON = N'09/10/2023', @NGAYTRA = N'29/10/2023', @SOLUONG = 1, @TINHTRANG = N'Mới', @GHICHU = N'';
EXEC THEMMUONTRA @MAMUON = N'MUON012', @MASV = N'20210027', @GMAIL = N'20210027@eaut.edu.vn', @TENSACH = N'The Bible', @MASACH = N'SK013', @NGAYMUON = N'10/10/2023', @NGAYTRA = N'30/10/2023', @SOLUONG = 1, @TINHTRANG = N'Mới', @GHICHU = N'';
EXEC THEMMUONTRA @MAMUON = N'MUON013', @MASV = N'20210028', @GMAIL = N'20210028@eaut.edu.vn', @TENSACH = N'One Piece Vol. 100', @MASACH = N'SK012', @NGAYMUON = N'11/10/2023', @NGAYTRA = N'31/10/2023', @SOLUONG = 1, @TINHTRANG = N'Mới', @GHICHU = N'';
EXEC THEMMUONTRA @MAMUON = N'MUON014', @MASV = N'20210043', @GMAIL = N'20210043@eaut.edu.vn', @TENSACH = N'Introduction to Artificial Intelligence', @MASACH = N'SK018', @NGAYMUON = N'12/10/2023', @NGAYTRA = N'01/11/2023', @SOLUONG = 1, @TINHTRANG = N'Mới', @GHICHU = N'';
 


EXEC THEMHISTORY @GMAIL = N'20210533@eaut.edu.vn', @TIEUDE  = N'Hạn Trả Sách', @NOIDUNG = N'trả sách';
-- Lấy dữ liệu từ bảng LOGIN
SELECT * FROM LOGIN;

-- Lấy dữ liệu từ bảng DOCGIA
SELECT * FROM DOCGIA;

-- Lấy dữ liệu từ bảng SACH
SELECT * FROM SACH;

-- Lấy dữ liệu từ bảng MUONTRA
SELECT * FROM MUONTRA;

SELECT * FROM HISTORY;
-- Kiểm tra cấu trúc bảng LOGIN
EXEC sp_columns 'LOGIN';

-- Kiểm tra cấu trúc bảng DOCGIA
EXEC sp_columns 'DOCGIA';
