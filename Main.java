// NumberPrinter เป็นคลาสที่สืบทอดจาก Thread และมี run() ที่จะทำงานเมื่อเริ่ม thread
//ใน run() จะพิมพ์เลข 1-50 และมีการดีเลย์แบบสุ่มเพื่อจำลองการทำงานของ thread หลายตัวพร้อมกัน

// สร้างคลาสสำหรับพิมพ์ตัวเลข โดยทำงานเป็น thread
class NumberPrinter extends Thread {
    private int threadNumber;  // ตัวแปรเก็บหมายเลข ของ thread

    // Constructor รับหมายเลขของ thread
    public NumberPrinter(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    // method run() ที่จะถูกเรียกเมื่อเธรดเริ่มทำงาน
    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) { // วนลูปพิมพ์เลข 1 ถึง 50
            System.out.println("Thread #" + threadNumber + ": " + i); // แสดงผลลัพธ์ของแต่ละ thread

            try {
                Thread.sleep((int) (Math.random() * 100)); // หน่วงเวลาแบบสุ่ม 0-99 มิลลิวินาที เพื่อจำลองการทำงานของ thread
            } catch (InterruptedException e) {
                e.printStackTrace(); // แสดงข้อผิดพลาดหากมีการขัดจังหวะ thread ต้องใช้หากมีการใช้ sleep ต้องมี catch
            }
        }
    }
}

// คลาสหลักของโปรแกรม
public class Main {
    public static void main(String[] args) {
        // สร้าง thread 3 ตัว
        NumberPrinter t1 = new NumberPrinter(1);
        NumberPrinter t2 = new NumberPrinter(2);
        NumberPrinter t3 = new NumberPrinter(3);

        // เริ่มทำงานของแต่ละ thread
        t1.start();
        t2.start();
        t3.start();

    }


}
