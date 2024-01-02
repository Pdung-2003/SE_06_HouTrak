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