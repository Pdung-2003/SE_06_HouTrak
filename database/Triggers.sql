-- I. Triggers cho các bảng deleted
-- 1. Ho Khau
CREATE TRIGGER trg_HoKhau_Delete
ON HoKhau
AFTER DELETE
AS
BEGIN
    INSERT INTO HoKhau_Deleted (MaHoKhau, HoTenChuHo, NgayLap, DiaChi, KhuVuc, DeletedAt)
    SELECT MaHoKhau, HoTenChuHo, NgayLap, DiaChi, KhuVuc, GETDATE()
    FROM deleted;
END;

-- 2. Nhan Khau
CREATE TRIGGER trg_NhanKhau_Delete
ON NhanKhau
AFTER DELETE
AS
BEGIN
    INSERT INTO NhanKhau_Deleted (MaNhanKhau, HoTen, NgaySinh, TonGiao, SoCMNDCCCD, QueQuan, GioiTinh, MaHoKhau, DeletedAt)
    SELECT MaNhanKhau, HoTen, NgaySinh, TonGiao, SoCMNDCCCD, QueQuan, GioiTinh, MaHoKhau, GETDATE()
    FROM deleted;
END;
-- 3. Lich su
CREATE TRIGGER trg_LichSuThayDoi_Delete
ON LichSuThayDoi
AFTER DELETE
AS
BEGIN
    INSERT INTO LichSuThayDoi_Deleted (MaThayDoi, MaNhanKhau, MaHoKhau, ThongTinThayDoi, ThongTinTruoc, ThongTinSau, NguoiThayDoi, NgayThayDoi, DeletedAt)
    SELECT MaThayDoi, MaNhanKhau, MaHoKhau, ThongTinThayDoi, ThongTinTruoc, ThongTinSau, NguoiThayDoi, NgayThayDoi, GETDATE()
    FROM deleted;
END;
-- 4. Tam Tru
CREATE TRIGGER trg_TamTru_Delete
ON TamTru
AFTER DELETE
AS
BEGIN
    INSERT INTO TamTru_Deleted (MaGiayTamTru, MaNhanKhau, LyDo, ThoiGianBatDau, ThoiGianTamTru, DeletedAt)
    SELECT MaGiayTamTru, MaNhanKhau, LyDo, ThoiGianBatDau, ThoiGianTamTru, GETDATE()
    FROM deleted;
END;
-- 5. Tam vang
CREATE TRIGGER trg_TamVang_Delete
ON TamVang
AFTER DELETE
AS
BEGIN
    INSERT INTO TamVang_Deleted (MaGiayTamVang, MaNhanKhau, LyDo, NgayBatDau, NgayKetThuc, NoiTamTru, DeletedAt)
    SELECT MaGiayTamVang, MaNhanKhau, LyDo, NgayBatDau, NgayKetThuc, NoiTamTru, GETDATE()
    FROM deleted;
END;
-- 6. Khai tu
CREATE TRIGGER trg_KhaiTu_Delete
ON KhaiTu
AFTER DELETE
AS
BEGIN
    INSERT INTO KhaiTu_Deleted (MaGiayKhaiTu, MaNhanKhau, NguoiKhaiTu, ThoiGianKhaiTu, NguyenNhan, DeletedAt)
    SELECT MaGiayKhaiTu, MaNhanKhau, NguoiKhaiTu, ThoiGianKhaiTu, NguyenNhan, GETDATE()
    FROM deleted;
END;

-- II. Trigger tự động insert vào bảng LichSuThayDoi
-- 1. Insert nhankhau
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
        CAST(
            'HoTen: ' + i.HoTen +
            ', NgaySinh: ' + CONVERT(NVARCHAR, i.NgaySinh) +
            ', TonGiao: ' + i.TonGiao +
            ', SoCMNDCCCD: ' + i.SoCMNDCCCD +
            ', QueQuan: ' + i.QueQuan +
            ', GioiTinh: ' + i.GioiTinh +
            ', MaHoKhau: ' + i.MaHoKhau 
            AS NVARCHAR(MAX)
        ) AS ThongTinSau,
        @CurrentUser AS NguoiThayDoi,
        GETDATE() AS NgayThayDoi
    FROM INSERTED i;
END;

-- Check 
INSERT INTO NhanKhau (HoTen, NgaySinh, TonGiao, SoCMNDCCCD, QueQuan, GioiTinh, MaHoKhau)
VALUES
(N'Nguyễn Văn Phạm', '1998-07-16', N'Phật giáo', '093456780', N'Hà Nội', N'Nam', 'MHK00001')

DELETE FROM NhanKhau
WHERE SoCMNDCCCD = '093456780';
-- 2. UPDATE bảng NhanKhau
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
        CAST(
            'HoTen: ' + d.HoTen +
            ', NgaySinh: ' + CONVERT(NVARCHAR, d.NgaySinh) +
            ', TonGiao: ' + d.TonGiao +
            ', SoCMNDCCCD: ' + d.SoCMNDCCCD +
            ', QueQuan: ' + d.QueQuan +
            ', GioiTinh: ' + d.GioiTinh +
            ', MaHoKhau: ' + d.MaHoKhau 
            AS NVARCHAR(MAX)
        ) AS ThongTinTruoc,
        CAST(
            'HoTen: ' + i.HoTen +
            ', NgaySinh: ' + CONVERT(NVARCHAR, i.NgaySinh) +
            ', TonGiao: ' + i.TonGiao +
            ', SoCMNDCCCD: ' + i.SoCMNDCCCD +
            ', QueQuan: ' + i.QueQuan +
            ', GioiTinh: ' + i.GioiTinh +
            ', MaHoKhau: ' + i.MaHoKhau 
            AS NVARCHAR(MAX)
        ) AS ThongTinSau,
        @CurrentUser AS NguoiThayDoi,
        GETDATE() AS NgayThayDoi
    FROM INSERTED i
    INNER JOIN DELETED d ON i.MaNhanKhau = d.MaNhanKhau;
END;

-- Delete bang NhanKhau
-- Trigger cho việc INSERT vào bảng NhanKhauDeleted
CREATE TRIGGER Tr_NhanKhauDeleted_Insert
ON NhanKhau_Deleted
AFTER INSERT
AS
BEGIN
    DECLARE @CurrentUser NVARCHAR(50);
    SET @CurrentUser = (SELECT SUSER_SNAME());

    INSERT INTO LichSuThayDoi (MaNhanKhau, MaHoKhau, ThongTinThayDoi, ThongTinTruoc, ThongTinSau, NguoiThayDoi, NgayThayDoi)
    SELECT 
        i.MaNhanKhau,
        i.MaHoKhau,
        'DELETE' AS ThongTinThayDoi,
        CAST(
            'HoTen: ' + i.HoTen +
            ', NgaySinh: ' + CONVERT(NVARCHAR, i.NgaySinh) +
            ', TonGiao: ' + i.TonGiao +
            ', SoCMNDCCCD: ' + i.SoCMNDCCCD +
            ', QueQuan: ' + i.QueQuan +
            ', GioiTinh: ' + i.GioiTinh +
            ', MaHoKhau: ' + i.MaHoKhau 
            AS NVARCHAR(MAX)
        ) AS ThongTinTruoc,
        NULL AS ThongTinSau,
        @CurrentUser AS NguoiThayDoi,
        GETDATE() AS NgayThayDoi
    FROM INSERTED i;
END;
-- 3. Trigger cho việc INSERT vào bảng HoKhau
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
        CAST(
            'HoTenChuHo: ' + i.HoTenChuHo +
            ', NgayLap: ' + CONVERT(NVARCHAR, i.NgayLap) +
            ', DiaChi: ' + i.DiaChi +
            ', KhuVuc: ' + i.KhuVuc 
            AS NVARCHAR(MAX)
        ) AS ThongTinSau,
        @CurrentUser AS NguoiThayDoi,
        GETDATE() AS NgayThayDoi
    FROM INSERTED i;
END;


-- Trigger cho việc UPDATE bảng HoKhau
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
        CAST(
            'HoTenChuHo: ' + d.HoTenChuHo +
            ', NgayLap: ' + CONVERT(NVARCHAR, d.NgayLap) +
            ', DiaChi: ' + d.DiaChi +
            ', KhuVuc: ' + d.KhuVuc 
            AS NVARCHAR(MAX)
        ) AS ThongTinTruoc,
        CAST(
            'HoTenChuHo: ' + i.HoTenChuHo +
            ', NgayLap: ' + CONVERT(NVARCHAR, i.NgayLap) +
            ', DiaChi: ' + i.DiaChi +
            ', KhuVuc: ' + i.KhuVuc 
            AS NVARCHAR(MAX)
        ) AS ThongTinSau,
        @CurrentUser AS NguoiThayDoi,
        GETDATE() AS NgayThayDoi
    FROM INSERTED i
    INNER JOIN DELETED d ON i.MaHoKhau = d.MaHoKhau;
END;

-- Delete HoKhau 
-- Trigger for INSERT into HoKhau_Deleted
CREATE TRIGGER Tr_HoKhauDeleted_Insert
ON HoKhau_Deleted
AFTER INSERT
AS
BEGIN
    DECLARE @CurrentUser NVARCHAR(50);
    SET @CurrentUser = (SELECT SUSER_SNAME());

    INSERT INTO LichSuThayDoi (MaNhanKhau, MaHoKhau, ThongTinThayDoi, ThongTinTruoc, ThongTinSau, NguoiThayDoi, NgayThayDoi)
    SELECT 
        NULL AS MaNhanKhau,
        i.MaHoKhau,
        'DELETE' AS ThongTinThayDoi,
        CAST(
            'HoTenChuHo: ' + i.HoTenChuHo +
            ', NgayLap: ' + CONVERT(NVARCHAR, i.NgayLap) +
            ', DiaChi: ' + i.DiaChi +
            ', KhuVuc: ' + i.KhuVuc 
            AS NVARCHAR(MAX)
        ) AS ThongTinSau,
        NULL AS ThongTinSau,
        @CurrentUser AS NguoiThayDoi,
        GETDATE() AS NgayThayDoi
    FROM INSERTED i;
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

CREATE TRIGGER trg_AfterInsert_KhoanThuPhi
ON KhoanThuPhi
AFTER INSERT
AS
BEGIN
    -- Insert tất cả MaHoKhau từ bảng HoKhau vào bảng KhoanThuHoKhau
    INSERT INTO KhoanThuHoKhau (MaKhoanThu, MaHoKhau, SoTienDong, TrangThai)
    SELECT
        i.MaKhoanThu,
        h.MaHoKhau,
        0,
        N'Chưa nộp'
    FROM
        inserted i
    CROSS JOIN HoKhau h; -- Sử dụng CROSS JOIN để chèn tất cả các MaHoKhau từ bảng HoKhau
END;