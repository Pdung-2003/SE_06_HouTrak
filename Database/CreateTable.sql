-- 1. Tạo bảng hộ khẩu 
CREATE TABLE HoKhau (
	STT INT IDENTITY(1, 1),
    MaHoKhau AS CONVERT(NVARCHAR(10), 'MHK' + RIGHT('00000' + CAST(STT AS VARCHAR(5)), 5)) PERSISTED PRIMARY KEY,
    HoTenChuHo NVARCHAR(225),
    NgayLap DATE,
    DiaChi NVARCHAR(255),
    KhuVuc NVARCHAR(50)
);

-- 2. Tạo bảng nhân khẩu
CREATE TABLE NhanKhau (
	STT INT IDENTITY(1, 1),
    MaNhanKhau AS CONVERT(NVARCHAR(10), 'MNK' + RIGHT('000000' + CAST(STT AS VARCHAR(5)), 5)) PERSISTED PRIMARY KEY,
    HoTen NVARCHAR(255),
    NgaySinh DATE,
    TonGiao NVARCHAR(50),
    SoCMNDCCCD NVARCHAR(20),
    QueQuan NVARCHAR(255),
    GioiTinh NVARCHAR(10),
    MaHoKhau NVARCHAR(10),
    FOREIGN KEY (MaHoKhau) REFERENCES HoKhau(MaHoKhau)
);

-- 3. Tạo bảng Lịch sử thay đổi thông tin nhân khẩu hộ khẩu
CREATE TABLE LichSuThayDoi (
	STT INT IDENTITY(1, 1),
    MaThayDoi AS CONVERT(NVARCHAR(10), 'MTD' + RIGHT('000000' + CAST(STT AS VARCHAR(5)), 5)) PERSISTED PRIMARY KEY,
    MaNhanKhau NVARCHAR(10),
	MaHoKhau NVARCHAR(10),
    ThongTinThayDoi NVARCHAR(MAX),
    ThongTinTruoc NVARCHAR(MAX),
    ThongTinSau NVARCHAR(MAX),
    NguoiThayDoi NVARCHAR(255),
    NgayThayDoi DATE,
    FOREIGN KEY (MaNhanKhau) REFERENCES NhanKhau(MaNhanKhau),
	FOREIGN KEY (MaHoKhau) REFERENCES HoKhau(MaHoKhau)
);

--4. Tạo bảng Tạm trú (nhân khẩu tạm trú)
CREATE TABLE TamTru (
	STT INT IDENTITY(1, 1),
    MaGiayTamTru AS CONVERT(NVARCHAR(10), 'MTT' + RIGHT('000000' + CAST(STT AS VARCHAR(5)), 5)) PERSISTED PRIMARY KEY,
    MaNhanKhau NVARCHAR(10),
    LyDo NVARCHAR(255),
    ThoiGianBatDau DATE,
    ThoiGianTamTru DATE,
    FOREIGN KEY (MaNhanKhau) REFERENCES NhanKhau(MaNhanKhau)
);

--5. Tạo bảng Tạm vắng (nhân khẩu tạm vắng)
CREATE TABLE TamVang (
	STT INT IDENTITY(1, 1),
    MaGiayTamVang AS CONVERT(NVARCHAR(10), 'MTV' + RIGHT('000000' + CAST(STT AS VARCHAR(5)), 5)) PERSISTED PRIMARY KEY,
    MaNhanKhau NVARCHAR(10),
    LyDo NVARCHAR(255),
    NgayBatDau DATE,
    NgayKetThuc DATE,
    NoiTamTru NVARCHAR(255),
    FOREIGN KEY (MaNhanKhau) REFERENCES NhanKhau(MaNhanKhau)
);

--6. Tạo bảng Khai tử (nhân khẩu qua đời)
CREATE TABLE KhaiTu (
	STT INT IDENTITY(1, 1),
    MaGiayKhaiTu AS CONVERT(NVARCHAR(10), 'MKT' + RIGHT('000000' + CAST(STT AS VARCHAR(5)), 5)) PERSISTED PRIMARY KEY,
    MaNhanKhau NVARCHAR(10),
    NguoiKhaiTu NVARCHAR(255),
    ThoiGianKhaiTu DATETIME,
    NguyenNhan NVARCHAR(MAX),
    FOREIGN KEY (MaNhanKhau) REFERENCES NhanKhau(MaNhanKhau)
);

--7. Tạo bảng Quỹ
CREATE TABLE Quy (
    SoTien DECIMAL(18, 2) PRIMARY KEY
);

--8. Tạo bảng Khoản thu phí từ các hộ
CREATE TABLE KhoanThuPhi (
	STT INT IDENTITY(1, 1),
    MaKhoanThu AS CONVERT(NVARCHAR(10), 'MKT' + RIGHT('0000' + CAST(STT AS VARCHAR(5)), 5)) PERSISTED PRIMARY KEY,
    ThoiGianThu DATE,
    LyDoThu NVARCHAR(255),
    NguoiThu NVARCHAR(255),
    SoTien DECIMAL(18, 2)
);
-- Tạo bảng kết nối Khoản thu - Hộ khẩu
CREATE TABLE KhoanThuHoKhau (
    MaKhoanThu NVARCHAR(10),
    MaHoKhau NVARCHAR(10),
	SoTienDong DECIMAL(18, 2),
	TenNguoiDong NVARCHAR(255),
    FOREIGN KEY (MaKhoanThu) REFERENCES KhoanThuPhi(MaKhoanThu),
    FOREIGN KEY (MaHoKhau) REFERENCES HoKhau(MaHoKhau),
    PRIMARY KEY (MaKhoanThu, MaHoKhau)
);

--9. Tạo bảng Khoản chi (Chi cho chính sách phát thưởng)
CREATE TABLE KhoanChi (
	STT INT IDENTITY(1, 1),
    MaKhoanChi AS CONVERT(NVARCHAR(10), 'MKC' + RIGHT('0000' + CAST(STT AS VARCHAR(5)), 5)) PERSISTED PRIMARY KEY,
    SoTien DECIMAL(18, 2),
    NguoiChi NVARCHAR(255),
    LyDo NVARCHAR(255),
    ThoiGian DATE
);

--10. Tạo bảng Danh sách học sinh (nhân khẩu là học sinh)
CREATE TABLE DanhSachHocSinh (
    MaNhanKhau NVARCHAR(10),
    HocLuc NVARCHAR(50),
    Lop INT,
    FOREIGN KEY (MaNhanKhau) REFERENCES NhanKhau(MaNhanKhau)
);

--11. Tạo bảng Thưởng
CREATE TABLE Thuong (
    MaNhanKhau NVARCHAR(10),
    ThoiGianNhan DATE,
    MaPhanThuong NVARCHAR(10),
    Soluong INT,
    LyDo NVARCHAR(255),
	FOREIGN KEY (MaPhanThuong) REFERENCES DanhSachPhanThuong(MaPhanThuong),
	FOREIGN KEY (MaNhanKhau) REFERENCES NhanKhau(MaNhanKhau)
);

--12. Tạo bảng Danh sách các phần thưởng
CREATE TABLE DanhSachPhanThuong (
    STT INT IDENTITY(1, 1),
    MaPhanThuong AS CONVERT(NVARCHAR(10), 'MPT' + RIGHT('0000' + CAST(STT AS VARCHAR(5)), 5)) PERSISTED PRIMARY KEY,
    TenPhanThuong NVARCHAR(255),
    GiaTri INT,
    SoLuong INT
);

-- Tạo bảng User
CREATE TABLE Users (
	STT INT IDENTITY(1, 1),
    MaUser AS CONVERT(NVARCHAR(10), 'CRU' + RIGHT('00000' + CAST(STT AS VARCHAR(5)), 5)) PERSISTED PRIMARY KEY,
	MaNhanVien NVARCHAR(10),
	ChucVu NVARCHAR(50),
    Username NVARCHAR(50),
    Password NVARCHAR(50),
);

INSERT INTO Users (MaNhanVien, ChucVu, Username, Password)
VALUES
('MNV0001', N'Tổ trưởng', 'totruong',123456);

-- Xóa bảng nếu cần 
DROP TABLE DanhSachPhanThuong
DROP TABLE DanhSachHocSinh
DROP TABLE KhoanThuHoKhau
DROP TABLE KhaiTu
DROP TABLE KhoanChi
DROP TABLE KhoanThuPhi
DROP TABLE TamTru
DROP TABLE TamVang
DROP TABLE LichSuThayDoi
DROP TABLE Quy
DROP TABLE Thuong
DROP TABLE NhanKhau
DROP TABLE HoKhau

-- Insert dữ liệu 
INSERT INTO HoKhau (HoTenChuHo, NgayLap, DiaChi, KhuVuc)
VALUES
(N'Vũ Thị Loan', '2023-01-01', N'123 Đường ABC, Quận XYZ', N'Khu vực A'),
(N'Vi Vĩnh Hưng', '2023-01-02', N'456 Đường XYZ, Quận ABC', N'Khu vực B'),
(N'Lê Phúc Hưng', '2023-01-03', N'789 Đường DEF, Quận XYZ', N'Khu vực C'),
(N'Trần Trung Nghĩa', '2023-01-04', N'101 Đường GHI, Quận DEF', N'Khu vực D'),
(N'Phạm Đức Dũng', '2023-01-05', N'202 Đường JKL, Quận MNO', N'Khu vực E'),
(N'Phạm Minh Đạt', '2023-01-06', N'303 Đường PQR, Quận STU', N'Khu vực F'),
(N'Vũ Tuấn', '2023-01-07', N'404 Đường VWX, Quận YZA', N'Khu vực G'),
(N'Trần Hữu Khang', '2023-01-08', N'505 Đường BCD, Quận EFG', N'Khu vực H'),
(N'Tống Văn Chiến', '2023-01-09', N'606 Đường HIJ, Quận KLM', N'Khu vực I'),
(N'Trương Văn Vạn', '2023-01-10', N'707 Đường NOP, Quận RST', N'Khu vực J');

INSERT INTO NhanKhau (HoTen, NgaySinh, BietDanh, TonGiao, SoCMNDCCCD, QueQuan, GioiTinh, MaHoKhau)
VALUES
(N'Nguyễn Văn An', '1990-03-15', N'A', N'Phật giáo', '123456789', N'Hà Nội', N'Nam', 'MHK00001'),
(N'Vũ Thị Loan', '1995-05-20', N'B', N'Phật giáo', '987654321', N'Hà Nội', N'Nữ', 'MHK00001'),
(N'Vi Vĩnh Hưng', '1985-12-10', N'C', N'Phật giáo', '543216789', N'Hồ Chí Minh', N'Nam', 'MHK00002'),
(N'Lê Thị Dung', '1992-09-18', N'D', N'Phật giáo', '987123456', N'Hà Nội', N'Nữ', 'MHK00002'),
(N'Lê Phúc Hưng', '1988-07-30', N'E', N'Phật giáo', '123789456', N'Hà Nội', N'Nam', 'MHK00003'),
(N'Đỗ Thị Phan', '1997-11-22', N'F', N'Phật giáo', '987654123', N'Hà Nội', N'Nữ', 'MHK00003'),
(N'Bùi Văn Giang', '1993-04-05', N'G', N'Phật giáo', '123456987', N'Hà Nội', N'Nam', 'MHK00003'),
(N'Ngô Thị Hoan', '1989-06-29', N'H', N'Phật giáo', '789123456', N'Hà Nội', N'Nữ', 'MHK00004'),
(N'Trần Trung Nghĩa', '1991-08-14', N'I', N'Phật giáo', '654321789', N'Hà Nội', N'Nam', 'MHK00004'),
(N'Lý Thị Khang', '1996-02-25', N'K', N'Phật giáo', '987123789', N'Hà Nội', N'Nữ', 'MHK00005'),
(N'Phạm Đức Dũng', '1987-10-01', N'L', N'Phật giáo', '123987654', N'Hà Nội', N'Nam', 'MHK00005'),
(N'Phạm Minh Đạt', '1994-09-03', N'M', N'Phật giáo', '789654321', N'Hà Nội', N'Nam', 'MHK00006'),
(N'Vũ Tuấn', '1986-06-14', N'N', N'Phật giáo', '123789654', N'Hà Nội', N'Nam', 'MHK00007'),
(N'Mai Thị Phương', '1990-05-12', N'P', N'Phật giáo', '789321654', N'Hà Nội', N'Nữ', 'MHK00008'),
(N'Phan Văn Quang', '1992-04-20', N'Q', N'Phật giáo', '123654789', N'Hà Nội', N'Nam', 'MHK00008'),
(N'Trần Hữu Khang', '1984-08-17', N'R', N'Phật giáo', '654987321', N'Hà Nội', N'Nam', 'MHK00008'),
(N'Ân Thị Son', '1993-07-26', N'S', N'Thiên chúa giáo', '987123789', N'Hà Nội', N'Nữ', 'MHK00009'),
(N'Tống Văn Chiến', '1988-12-09', N'T', N'Thiên chúa giáo', '123654987', N'Hà Nội', N'Nam', 'MHK00009'),
(N'Chu Thị Uyên', '1991-03-11', N'U', N'Phật giáo', '789321987', N'Hà Nội', N'Nữ', 'MHK00010'),
(N'Trương Văn Vạn', '1997-01-28', N'V', N'Phật giáo', '987321654', N'Hà Nội', N'Nam', 'MHK00010');

-- Trigger cho việc INSERT vào bảng NhanKhau
CREATE TRIGGER Tr_NhanKhau_Insert
ON NhanKhau
AFTER INSERT
AS
BEGIN
    DECLARE @CurrentUser NVARCHAR(50);
    SET @CurrentUser = (SELECT SUSER_SNAME());

    INSERT INTO LichSuThayDoi (MaNhanKhau, MaHoKhau, ThongTinThayDoi, ThongTinTruoc, ThongTinSau, NguoiThayDoi, NgayThayDoi)
    SELECT 
        i.MaNhanKhau,
        i.MaHoKhau,
        'INSERT' AS ThongTinThayDoi,
        NULL AS ThongTinTruoc,
        CAST('HoTen: ' + i.HoTen + ', NgaySinh: ' + CONVERT(NVARCHAR, i.NgaySinh) AS NVARCHAR(MAX)) AS ThongTinSau,
        @CurrentUser AS NguoiThayDoi,
        GETDATE() AS NgayThayDoi
    FROM INSERTED i;
END;

CREATE TRIGGER Tr_NhanKhau_Delete
ON NhanKhau
AFTER DELETE
AS
BEGIN
    DECLARE @CurrentUser NVARCHAR(50);
    SET @CurrentUser = (SELECT SUSER_SNAME());

    -- Xóa dữ liệu tương ứng từ bảng LichSuThayDoi trước
    DELETE FROM LichSuThayDoi
    WHERE MaNhanKhau IN (SELECT MaNhanKhau FROM DELETED);

    -- Thêm dữ liệu vào LichSuThayDoi sau khi đã xóa
    INSERT INTO LichSuThayDoi (MaNhanKhau, MaHoKhau, ThongTinThayDoi, ThongTinTruoc, ThongTinSau, NguoiThayDoi, NgayThayDoi)
    SELECT 
        d.MaNhanKhau,
        d.MaHoKhau,
        'DELETE' AS ThongTinThayDoi,
        CAST('HoTen: ' + d.HoTen + ', NgaySinh: ' + CONVERT(NVARCHAR, d.NgaySinh) AS NVARCHAR(MAX)) AS ThongTinTruoc,
        NULL AS ThongTinSau,
        @CurrentUser AS NguoiThayDoi,
        GETDATE() AS NgayThayDoi
    FROM DELETED d;
END;

-- Trigger cho việc UPDATE bảng NhanKhau
CREATE TRIGGER Tr_NhanKhau_Update
ON NhanKhau
AFTER UPDATE
AS
BEGIN
    DECLARE @CurrentUser NVARCHAR(50);
    SET @CurrentUser = (SELECT SUSER_SNAME());

    INSERT INTO LichSuThayDoi (MaNhanKhau, MaHoKhau, ThongTinThayDoi, ThongTinTruoc, ThongTinSau, NguoiThayDoi, NgayThayDoi)
    SELECT 
        i.MaNhanKhau,
        i.MaHoKhau,
        'UPDATE' AS ThongTinThayDoi,
        CAST('HoTen: ' + d.HoTen + ', NgaySinh: ' + CONVERT(NVARCHAR, d.NgaySinh) AS NVARCHAR(MAX)) AS ThongTinTruoc,
        CAST('HoTen: ' + i.HoTen + ', NgaySinh: ' + CONVERT(NVARCHAR, i.NgaySinh) AS NVARCHAR(MAX)) AS ThongTinSau,
        @CurrentUser AS NguoiThayDoi,
        GETDATE() AS NgayThayDoi
    FROM INSERTED i
    INNER JOIN DELETED d ON i.MaNhanKhau = d.MaNhanKhau;
END;

-- Trigger cho việc DELETE bảng NhanKhau
CREATE TRIGGER Tr_NhanKhau_Delete
ON NhanKhau
AFTER DELETE
AS
BEGIN
    DECLARE @CurrentUser NVARCHAR(50);
    SET @CurrentUser = (SELECT SUSER_SNAME());

    INSERT INTO LichSuThayDoi (MaNhanKhau, MaHoKhau, ThongTinThayDoi, ThongTinTruoc, ThongTinSau, NguoiThayDoi, NgayThayDoi)
    SELECT 
        d.MaNhanKhau,
        d.MaHoKhau,
        'DELETE' AS ThongTinThayDoi,
        CAST('HoTen: ' + d.HoTen + ', NgaySinh: ' + CONVERT(NVARCHAR, d.NgaySinh) AS NVARCHAR(MAX)) AS ThongTinTruoc,
        NULL AS ThongTinSau,
        @CurrentUser AS NguoiThayDoi,
        GETDATE() AS NgayThayDoi
    FROM DELETED d;
END;

-- Trigger cho việc INSERT vào bảng HoKhau
CREATE TRIGGER Tr_HoKhau_Insert
ON HoKhau
AFTER INSERT
AS
BEGIN
    DECLARE @CurrentUser NVARCHAR(50);
    SET @CurrentUser = (SELECT SUSER_SNAME());

    INSERT INTO LichSuThayDoi (MaNhanKhau, MaHoKhau, ThongTinThayDoi, ThongTinTruoc, ThongTinSau, NguoiThayDoi, NgayThayDoi)
    SELECT 
        NULL AS MaNhanKhau,
        i.MaHoKhau,
        'INSERT' AS ThongTinThayDoi,
        NULL AS ThongTinTruoc,
        CAST('HoTenChuHo: ' + i.HoTenChuHo + ', NgayLap: ' + CONVERT(NVARCHAR, i.NgayLap) AS NVARCHAR(MAX)) AS ThongTinSau,
        @CurrentUser AS NguoiThayDoi,
        GETDATE() AS NgayThayDoi
    FROM INSERTED i;
END;

-- Trigger cho việc UPDATE bảng HoKhau
CREATE TRIGGER Tr_HoKhau_Update
ON HoKhau
AFTER UPDATE
AS
BEGIN
    DECLARE @CurrentUser NVARCHAR(50);
    SET @CurrentUser = (SELECT SUSER_SNAME());

    INSERT INTO LichSuThayDoi (MaNhanKhau, MaHoKhau, ThongTinThayDoi, ThongTinTruoc, ThongTinSau, NguoiThayDoi, NgayThayDoi)
    SELECT 
        NULL AS MaNhanKhau,
        i.MaHoKhau,
        'UPDATE' AS ThongTinThayDoi,
        CAST('HoTenChuHo: ' + d.HoTenChuHo + ', NgayLap: ' + CONVERT(NVARCHAR, d.NgayLap) AS NVARCHAR(MAX)) AS ThongTinTruoc,
        CAST('HoTenChuHo: ' + i.HoTenChuHo + ', NgayLap: ' + CONVERT(NVARCHAR, i.NgayLap) AS NVARCHAR(MAX)) AS ThongTinSau,
        @CurrentUser AS NguoiThayDoi,
        GETDATE() AS NgayThayDoi
    FROM INSERTED i
    INNER JOIN DELETED d ON i.MaHoKhau = d.MaHoKhau;
END;

-- Trigger cho việc DELETE bảng HoKhau
CREATE TRIGGER Tr_HoKhau_Delete
ON HoKhau
AFTER DELETE
AS
BEGIN
    DECLARE @CurrentUser NVARCHAR(50);
    SET @CurrentUser = (SELECT SUSER_SNAME());

    INSERT INTO LichSuThayDoi (MaNhanKhau, MaHoKhau, ThongTinThayDoi, ThongTinTruoc, ThongTinSau, NguoiThayDoi, NgayThayDoi)
    SELECT 
        NULL AS MaNhanKhau,
        d.MaHoKhau,
        'DELETE' AS ThongTinThayDoi,
        CAST('HoTenChuHo: ' + d.HoTenChuHo + ', NgayLap: ' + CONVERT(NVARCHAR, d.NgayLap) AS NVARCHAR(MAX)) AS ThongTinTruoc,
        NULL AS ThongTinSau,
        @CurrentUser AS NguoiThayDoi,
        GETDATE() AS NgayThayDoi
    FROM DELETED d;
END;

-- Check
INSERT INTO HoKhau (HoTenChuHo, NgayLap, DiaChi, KhuVuc)
VALUES
(N'Hà Văn Bách', '2023-01-01', N'123 Đường ABC, Quận HBT', N'Khu vực A')

-- Trigger cho SoTien trong Quy
CREATE TRIGGER AfterInsert_KhoanThuHoKhau
ON KhoanThuHoKhau
AFTER INSERT
AS
BEGIN
    UPDATE Quy
    SET SoTien = SoTien + (SELECT SUM(SoTienDong) FROM inserted)
END;

CREATE TRIGGER AfterUpdate_KhoanThuHoKhau
ON KhoanThuHoKhau
AFTER UPDATE
AS
BEGIN
    UPDATE Quy
    SET SoTien = SoTien + (SELECT SUM(SoTienDong) FROM inserted) - (SELECT SUM(SoTienDong) FROM deleted)
END;

CREATE TRIGGER AfterInsert_KhoanChi
ON KhoanChi
AFTER INSERT
AS
BEGIN
    UPDATE Quy
    SET SoTien = SoTien - (SELECT SUM(SoTien) FROM inserted)
END;

CREATE TRIGGER AfterUpdate_KhoanChi
ON KhoanChi
AFTER UPDATE
AS
BEGIN
    UPDATE Quy
    SET SoTien = SoTien - (SELECT SUM(SoTien) FROM inserted) + (SELECT SUM(SoTien) FROM deleted)
END;

-- Gán quyền CONTROL (toàn quyền) cho Tổ trưởng và Tổ phó
CREATE ROLE [Tổ trưởng]
GRANT CONTROL TO [Tổ trưởng]
CREATE ROLE [Tổ phó]
GRANT CONTROL TO [Tổ phó]
CREATE ROLE [Nhân viên quản lý hộ khẩu]
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.HoKhau TO [Nhân viên quản lý hộ khẩu]
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.NhanKhau TO [Nhân viên quản lý hộ khẩu]
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.TamTru TO [Nhân viên quản lý hộ khẩu]
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.TamVang TO [Nhân viên quản lý hộ khẩu]
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.KhaiTu TO [Nhân viên quản lý hộ khẩu]
CREATE ROLE [Nhân viên quản lý thu chi]
-- Gán các quyền cụ thể cho Nhân viên quản lý thu chi
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.KhoanThuPhi TO [Nhân viên quản lý thu chi]
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.KhoanThuHoKhau TO [Nhân viên quản lý thu chi]
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.Quy TO [Nhân viên quản lý thu chi]
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.KhoanChi TO [Nhân viên quản lý thu chi]
-- Gán các quyền khác nếu cần
CREATE ROLE [Nhân viên quản lý phát thưởng]
-- Gán các quyền cụ thể cho Nhân viên quản lý phát thưởng
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.DanhSachPhanThuong TO [Nhân viên quản lý phát thưởng]
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.Thuong TO [Nhân viên quản lý phát thưởng]
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.DanhSachHocSinh TO [Nhân viên quản lý phát thưởng]
-- Gán các quyền khác nếu cần
USE master;
CREATE LOGIN totruong WITH PASSWORD = '123456';
CREATE LOGIN topho WITH PASSWORD = '123456';
CREATE LOGIN nhanvienhokhau WITH PASSWORD = '123456';
CREATE LOGIN nhanvienthuchi WITH PASSWORD = '123456';
CREATE LOGIN nhanvienphatthuong WITH PASSWORD = '123456';
USE HouTrak;
CREATE USER totruong FOR LOGIN totruong;
ALTER ROLE [Tổ trưởng] ADD MEMBER totruong;
CREATE USER topho FOR LOGIN topho;
ALTER ROLE [Tổ phó] ADD MEMBER topho;
CREATE USER nhanvienhokhau FOR LOGIN nhanvienhokhau;
ALTER ROLE [Nhân viên quản lý hộ khẩu] ADD MEMBER nhanvienhokhau;
CREATE USER nhanvienthuchi FOR LOGIN nhanvienthuchi;
ALTER ROLE [Nhân viên quản lý thu chi] ADD MEMBER nhanvienthuchi;
CREATE USER nhanvienphatthuong FOR LOGIN nhanvienphatthuong;
ALTER ROLE [Nhân viên quản lý phát thưởng] ADD MEMBER nhanvienphatthuong;