flow code
-Khi request đến link liên quan đến authen thì sẽ chạy vào CustomerJwtFilter. 
Lấy token đc lưu trên header và giải mã xem có phải từ server mình sinh ra k(doFilterInterval)
sau đó khi họ call các api có chứng thực thì dc phép