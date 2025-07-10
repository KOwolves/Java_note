# JavaIO
## File
### 创建
- `public File(String pathname)`：文件路径
- `public File(String parent, String child)`：父路径 + 子路径
- `public File(File parent, String child)`

### 常用方法
#### 信息
- `public boolean exists()`
- `public boolean isFile()`
- `public boolean isDirectory()`
- `public String getName()`
- `public long length()`
- `public long lastModified()`：最后修改时间
- `public String getPath()`
- `public String getAbsolutePath()`

#### 动作
- `public boolean createNewFile()`
- `public boolean mkdir()`
- `public boolean mkdirs()`：多级目录
- `public boolean delete()`

#### 遍历
- `public String[] list()`
- `public File[] ListFiles()`

## IO流
### 字节流
#### 文件字节输入流
- `public FileInputStream(File file)`
- `public FileInputStream(String pathname)`
- `public int read()`：1个字节
- `public int read(byte[] buffer)`：缓冲区读多字节
- `public byte[] readAllBytes()`：读取全部字节

#### 文件字节输出流
- `public FileOutputStream(File file)`
- `public FileOutputStream(String pathname)`
- `public FileOutputStream(File file, boolean append)`
- `public FileOutputStream(String pathname, boolean append)`
- `public void write(int a)`
- `public void write(byte[] buffer)`
- `public void write(byte[] buffer, int pos, int len)`


### 字符流
#### 文件字符输入流
- `public FileReader(File file)`
- `public FileReader(String pathname)`
- `public int read()`：1个字符
- `public int read(char[] buffer)`：缓冲区读多字符

#### 文件字符输出流
- `FileWriter`：定义与使用与字节输出流类似
- 注：写入文件后必须 `flush` 或 `close` 流才生效
