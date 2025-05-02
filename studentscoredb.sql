-- Bảng Classes: quản lý lớp học
CREATE TABLE class (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Bảng Users: lưu thông tin tài khoản
CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('admin', 'lecturer', 'student') NOT NULL,
    avatar_url VARCHAR(500),
    student_code VARCHAR(50),
    lecturer_code VARCHAR(50),
    class_id INT, -- Một sinh viên thuộc 1 lớp (nếu là sinh viên)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `active` bit(1) DEFAULT b'1',
    FOREIGN KEY (class_id) REFERENCES class(id)
);

-- Bảng Subjects: thông tin môn học
CREATE TABLE subject (
    id INT AUTO_INCREMENT PRIMARY KEY,
    subject_code VARCHAR(50) UNIQUE NOT NULL,
    subject_name VARCHAR(255) NOT NULL,
    description TEXT, -- Thêm mô tả môn học
    credits INT DEFAULT 3
);

-- Bảng Class_Subjects: môn học gán cho lớp
CREATE TABLE class_subject (
    id INT AUTO_INCREMENT PRIMARY KEY,
    class_id INT NOT NULL,
    subject_id INT NOT NULL,
    FOREIGN KEY (class_id) REFERENCES class(id),
    FOREIGN KEY (subject_id) REFERENCES subject(id)
);

-- Bảng Scores: điểm sinh viên
CREATE TABLE score (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    class_subject_id INT NOT NULL,
    midterm_score FLOAT,
    final_score FLOAT,
    extra_score1 FLOAT,
    extra_score2 FLOAT,
    extra_score3 FLOAT,
    lock_status ENUM('draft', 'locked') DEFAULT 'draft',
    updated_by INT,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES user(id),
    FOREIGN KEY (class_subject_id) REFERENCES class_subject(id),
    FOREIGN KEY (updated_by) REFERENCES user(id)
);

-- Bảng Forum_Posts: bài post trên diễn đàn
CREATE TABLE forum_post (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    author_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (author_id) REFERENCES user(id)
);

-- Bảng Forum_Comments: comment bài viết
CREATE TABLE forum_comment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    post_id INT NOT NULL,
    content TEXT NOT NULL,
    author_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES forum_post(id),
    FOREIGN KEY (author_id) REFERENCES user(id)
);

-- Insert vào Classes trước
INSERT INTO class (name)
VALUES 
('CNTT2021A'),
('CNTT2021B');

-- Insert vào Users (2 admin, 2 giảng viên, 5 sinh viên)
INSERT INTO user (first_name,last_name, email, password, role, avatar_url, student_code, lecturer_code, class_id)
VALUES 
('Nguyen Van', 'A', 'admin1@university.edu.vn', 'hashedpassword', 'admin', NULL, NULL, NULL, NULL),
('Tran Thi', 'B', 'admin2@university.edu.vn', 'hashedpassword', 'admin', NULL, NULL, NULL, NULL),
('Le Van', 'C', 'lecturer1@university.edu.vn', 'hashedpassword', 'lecturer', NULL, NULL, 'GV001', NULL),
('Pham Thi', 'D', 'lecturer2@university.edu.vn', 'hashedpassword', 'lecturer', NULL, NULL, 'GV002', NULL),
('Ho', 'One', 'sv1@student.university.edu.vn', 'hashedpassword', 'student', NULL, 'SV001', NULL, 1),
('Student', 'One', 'sv2@student.university.edu.vn', 'hashedpassword', 'student', NULL, 'SV002', NULL, 1),
('Student', 'One', 'sv3@student.university.edu.vn', 'hashedpassword', 'student', NULL, 'SV003', NULL, 1),
('Student', 'One', 'sv4@student.university.edu.vn', 'hashedpassword', 'student', NULL, 'SV004', NULL, 2),
('Student', 'One', 'sv5@student.university.edu.vn', 'hashedpassword', 'student', NULL, 'SV005', NULL, 2);

-- Insert vào Subjects
INSERT INTO subject (subject_code, subject_name, description, credits)
VALUES 
('CT101', 'Cấu trúc dữ liệu', 'Học về cây, danh sách, đồ thị và thuật toán.', 3),
('CN202', 'Mạng máy tính', 'Kiến thức căn bản về hệ thống mạng.', 3),
('LT303', 'Lập trình hướng đối tượng', 'Lập trình Java, thiết kế OOP.', 4);

-- Gán môn cho lớp
INSERT INTO class_subject (class_id, subject_id)
VALUES 
(1, 1),
(1, 3),
(2, 2),
(2, 3);

-- Điểm mẫu
INSERT INTO score (student_id, class_subject_id, midterm_score, final_score, extra_score1, lock_status, updated_by)
VALUES 
(5, 1, 7.5, 8.0, NULL, 'locked', 3),
(6, 1, 6.0, 7.0, NULL, 'locked', 3),
(7, 1, 8.5, 9.0, NULL, 'locked', 3),
(8, 2, 7.0, 7.5, NULL, 'draft', 4),
(9, 2, 5.5, 6.0, NULL, 'draft', 4);

-- Forum Posts
INSERT INTO forum_post (title, content, author_id)
VALUES 
('Cách tính điểm giữa kỳ?', 'Thầy ơi cho em hỏi điểm giữa kỳ được tính như thế nào?', 5),
('Điểm final em thấp', 'Em muốn được phúc khảo điểm final ạ.', 6);

-- Forum Comments
INSERT INTO forum_comment (post_id, content, author_id)
VALUES 
(1, 'Điểm giữa kỳ lấy từ bài tập và kiểm tra giữa kỳ.', 3),
(2, 'Em gửi đơn phúc khảo lên văn phòng khoa nhé.', 4);
