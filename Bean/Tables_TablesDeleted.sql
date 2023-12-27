-- 1. Tạo bảng hộ khẩu 
CREATE TABLE HoKhau (
	STT INT IDENTITY(1, 1),
    MaHoKhau AS CONVERT(NVARCHAR(10), 'MHK' + RIGHT('00000' + CAST(STT AS VARCHAR(5)), 5)) PERSISTED PRIMARY KEY,
    HoTenChuHo NVARCHAR(225),
    NgayLap DATE DEFAULT GETDATE(),
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
    SoCMNDCCCD NVARCHAR(20) UNIQUE,
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
    NgayThayDoi DATE DEFAULT GETDATE(),
);

DROP TABLE LichSuThayDoi
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
--9. Tạo bảng kết nối Khoản thu - Hộ khẩu
CREATE TABLE KhoanThuHoKhau (
    MaKhoanThu NVARCHAR(10),
    MaHoKhau NVARCHAR(10),
	SoTienDong DECIMAL(18, 2),
	TenNguoiDong NVARCHAR(255),
    FOREIGN KEY (MaKhoanThu) REFERENCES KhoanThuPhi(MaKhoanThu),
    FOREIGN KEY (MaHoKhau) REFERENCES HoKhau(MaHoKhau),
    PRIMARY KEY (MaKhoanThu, MaHoKhau)
);

--10. Tạo bảng Khoản chi (Chi cho chính sách phát thưởng)
CREATE TABLE KhoanChi (
	STT INT IDENTITY(1, 1),
    MaKhoanChi AS CONVERT(NVARCHAR(10), 'MKC' + RIGHT('0000' + CAST(STT AS VARCHAR(5)), 5)) PERSISTED PRIMARY KEY,
    SoTien DECIMAL(18, 2),
    NguoiChi NVARCHAR(255),
    LyDo NVARCHAR(255),
    ThoiGian DATE
);

--11. Tạo bảng Danh sách học sinh (nhân khẩu là học sinh)
CREATE TABLE DanhSachHocSinh (
    MaNhanKhau NVARCHAR(10),
    HocLuc NVARCHAR(50),
    Lop INT,
    FOREIGN KEY (MaNhanKhau) REFERENCES NhanKhau(MaNhanKhau)
);

--12. Tạo bảng Thưởng
CREATE TABLE Thuong (
    MaNhanKhau NVARCHAR(10),
    ThoiGianNhan DATE,
    MaPhanThuong NVARCHAR(10),
    Soluong INT,
    LyDo NVARCHAR(255),
	FOREIGN KEY (MaPhanThuong) REFERENCES DanhSachPhanThuong(MaPhanThuong),
	FOREIGN KEY (MaNhanKhau) REFERENCES NhanKhau(MaNhanKhau)
);

--13. Tạo bảng Danh sách các phần thưởng
CREATE TABLE DanhSachPhanThuong (
    STT INT IDENTITY(1, 1),
    MaPhanThuong AS CONVERT(NVARCHAR(10), 'MPT' + RIGHT('0000' + CAST(STT AS VARCHAR(5)), 5)) PERSISTED PRIMARY KEY,
    TenPhanThuong NVARCHAR(255),
    GiaTri INT,
    SoLuong INT
);

--14 Tạo bảng User
CREATE TABLE Users (
	STT INT IDENTITY(1, 1),
    MaUser AS CONVERT(NVARCHAR(10), 'CRU' + RIGHT('00000' + CAST(STT AS VARCHAR(5)), 5)) PERSISTED PRIMARY KEY,
	MaNhanVien NVARCHAR(10),
	ChucVu NVARCHAR(50),
    Username NVARCHAR(50),
    Password NVARCHAR(50),
);

-- 15. Tạo bảng ChinhSachThuong
CREATE TABLE ChinhSachThuong (
	STT INT IDENTITY(1, 1),
    MaChinhSach AS CONVERT(NVARCHAR(10), 'MCS' + RIGHT('0000' + CAST(STT AS VARCHAR(5)), 5)) PERSISTED PRIMARY KEY,
	DoiTuong NVARCHAR(50),
	Lop INT,
	HocLuc NVARCHAR(20),
	PhanThuong NVARCHAR(50),
	SoLuong INT,
);
ALTER TABLE ChinhSachThuong
DROP COLUMN DoiTuong;
ALTER TABLE ChinhSachThuong
ADD Date DATE

-- 16. Tạo bảng ChinhSachThuong ngay le
CREATE TABLE ChinhSachThuongLe (
	STT INT IDENTITY(1, 1),
    MaChinhSach AS CONVERT(NVARCHAR(10), 'MTL' + RIGHT('0000' + CAST(STT AS VARCHAR(5)), 5)) PERSISTED PRIMARY KEY,
	NgayLe NVARCHAR(50),
	Tuoi INT,
	PhanThuong NVARCHAR(50),
	SoLuong INT,
);
ALTER TABLE ChinhSachThuongLe
ADD Date DATE

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

INSERT INTO NhanKhau (HoTen, NgaySinh, TonGiao, SoCMNDCCCD, QueQuan, GioiTinh, MaHoKhau)
VALUES
(N'Nguyễn Văn An', '1990-03-15', N'Phật giáo', '123456780', N'Hà Nội', N'Nam', 'MHK00001'),
(N'Vũ Thị Loan', '1995-05-20', N'Phật giáo', '987654321', N'Hà Nội', N'Nữ', 'MHK00001'),
(N'Vi Vĩnh Hưng', '1985-12-10', N'Phật giáo', '543216782', N'Hồ Chí Minh', N'Nam', 'MHK00002'),
(N'Lê Thị Dung', '1992-09-18', N'Phật giáo', '987123453', N'Hà Nội', N'Nữ', 'MHK00002'),
(N'Lê Phúc Hưng', '1988-07-30', N'Phật giáo', '123789454', N'Hà Nội', N'Nam', 'MHK00003'),
(N'Đỗ Thị Phan', '1997-11-22', N'Phật giáo', '987654125', N'Hà Nội', N'Nữ', 'MHK00003'),
(N'Bùi Văn Giang', '1993-04-05', N'Phật giáo', '123456986', N'Hà Nội', N'Nam', 'MHK00003'),
(N'Ngô Thị Hoan', '1989-06-29', N'Phật giáo', '789123457', N'Hà Nội', N'Nữ', 'MHK00004'),
(N'Trần Trung Nghĩa', '1991-08-14', N'Phật giáo', '654321788', N'Hà Nội', N'Nam', 'MHK00004'),
(N'Lý Thị Khang', '1996-02-25', N'Phật giáo', '987123789', N'Hà Nội', N'Nữ', 'MHK00005'),
(N'Phạm Đức Dũng', '1987-10-01', N'Phật giáo', '123987650', N'Hà Nội', N'Nam', 'MHK00005'),
(N'Phạm Minh Đạt', '1994-09-03', N'Phật giáo', '789654322', N'Hà Nội', N'Nam', 'MHK00006'),
(N'Vũ Tuấn', '1986-06-14',  N'Phật giáo', '123789651', N'Hà Nội', N'Nam', 'MHK00007'),
(N'Mai Thị Phương', '1990-05-12', N'Phật giáo', '789321653', N'Hà Nội', N'Nữ', 'MHK00008'),
(N'Phan Văn Quang', '1992-04-20', N'Phật giáo', '123654784', N'Hà Nội', N'Nam', 'MHK00008'),
(N'Trần Hữu Khang', '1984-08-17', N'Phật giáo', '654987325', N'Hà Nội', N'Nam', 'MHK00008'),
(N'Ân Thị Son', '1993-07-26', N'Thiên chúa giáo', '987123786', N'Hà Nội', N'Nữ', 'MHK00009'),
(N'Tống Văn Chiến', '1988-12-09', N'Thiên chúa giáo', '123654989', N'Hà Nội', N'Nam', 'MHK00009'),
(N'Chu Thị Uyên', '1991-03-11', N'Phật giáo', '789321986', N'Hà Nội', N'Nữ', 'MHK00010'),
(N'Trương Văn Vạn', '1997-01-28', N'Phật giáo', '987321652', N'Hà Nội', N'Nam', 'MHK00010');

INSERT INTO Users (MaNhanVien, ChucVu, Username, Password)
VALUES
('MNV0001', N'Tổ trưởng', 'totruong',123456);

INSERT INTO DanhSachHocSinh(MaNhanKhau, HocLuc, Lop) 
VALUES
('MNK00090', N'Giỏi', 8),
('MNK00093', NULL, NULL),
('MNK00062', 'Khá', 9),
('MNK00083', 'Giỏi', 10);

DELETE FROM DanhSachHocSinh WHERE MaNhanKhau = 'MNK00093'

-- Tạo bảng Deleted 
-- 1. Tạo bảng hộ khẩu 
CREATE TABLE HoKhau_Deleted (
    MaHoKhau NVARCHAR(10),
    HoTenChuHo NVARCHAR(225),
    NgayLap DATE,
    DiaChi NVARCHAR(255),
    KhuVuc NVARCHAR(50),
    DeletedAt DATETIME DEFAULT GETDATE()
);

-- 2. Tạo bảng nhân khẩu
CREATE TABLE NhanKhau_Deleted (
    MaNhanKhau NVARCHAR(10),
    HoTen NVARCHAR(255),
    NgaySinh DATE,
    TonGiao NVARCHAR(50),
    SoCMNDCCCD NVARCHAR(20),
    QueQuan NVARCHAR(255),
    GioiTinh NVARCHAR(10),
    MaHoKhau NVARCHAR(10),
    DeletedAt DATETIME DEFAULT GETDATE()
);

-- 3. Tạo bảng Lịch sử thay đổi thông tin nhân khẩu hộ khẩu
CREATE TABLE LichSuThayDoi_Deleted (
    MaThayDoi NVARCHAR(10),
    MaNhanKhau NVARCHAR(10),
    MaHoKhau NVARCHAR(10),
    ThongTinThayDoi NVARCHAR(MAX),
    ThongTinTruoc NVARCHAR(MAX),
    ThongTinSau NVARCHAR(MAX),
    NguoiThayDoi NVARCHAR(255),
    NgayThayDoi DATE,
    DeletedAt DATETIME DEFAULT GETDATE()
);

--4. Tạo bảng Tạm trú (nhân khẩu tạm trú)
CREATE TABLE TamTru_Deleted (
    MaGiayTamTru NVARCHAR(10),
    MaNhanKhau NVARCHAR(10),
    LyDo NVARCHAR(255),
    ThoiGianBatDau DATE,
    ThoiGianTamTru DATE,
    DeletedAt DATETIME DEFAULT GETDATE()
);

--5. Tạo bảng Tạm vắng (nhân khẩu tạm vắng)
CREATE TABLE TamVang_Deleted (
    MaGiayTamVang NVARCHAR(10),
    MaNhanKhau NVARCHAR(10),
    LyDo NVARCHAR(255),
    NgayBatDau DATE,
    NgayKetThuc DATE,
    NoiTamTru NVARCHAR(255),
    DeletedAt DATETIME DEFAULT GETDATE()
);

--6. Tạo bảng Khai tử (nhân khẩu qua đời)
CREATE TABLE KhaiTu_Deleted (
    MaGiayKhaiTu NVARCHAR(10),
    MaNhanKhau NVARCHAR(10),
    NguoiKhaiTu NVARCHAR(255),
    ThoiGianKhaiTu DATETIME,
    NguyenNhan NVARCHAR(MAX),
    DeletedAt DATETIME DEFAULT GETDATE()
);