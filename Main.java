import java.util.ArrayList;
import java.util.List;

// 定义一个记录接口
interface Record {
    String getContent();
    void setContent(String content);
}

// 实现记录接口的类
class TextRecord implements Record {
    private String content;
    private String timestamp;

    public TextRecord(String content, String timestamp) {
        this.content = content;
        this.timestamp = timestamp;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }
}

// 记录管理器类
class RecordManager {
    private List<Record> records;

    public RecordManager() {
        records = new ArrayList<>();
    }

    // 提交一条记录
    public void submitRecord(Record record) {
        records.add(record);
        System.out.println("记录已提交: " + record.getContent());
    }

    // 获取所有记录
    public List<Record> getAllRecords() {
        return records;
    }
}

// 主类，用于程序运行
public class Main {
    public static void main(String[] args) {
        RecordManager manager = new RecordManager();

        // 提交三条记录
        manager.submitRecord(new TextRecord("第一条记录内容", "2023-10-10 10:00"));
        manager.submitRecord(new TextRecord("第二条记录内容", "2023-10-10 10:05"));
        manager.submitRecord(new TextRecord("第三条记录内容", "2023-10-10 10:10"));

        // 输出所有记录
        System.out.println("\n所有记录：");
        for (Record record : manager.getAllRecords()) {
            System.out.println("时间: " + ((TextRecord) record).getTimestamp() + ", 内容: " + record.getContent());
        }
    }
}