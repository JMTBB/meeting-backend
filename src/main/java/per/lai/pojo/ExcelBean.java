package per.lai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelBean implements Serializable {

    private String headName;
    private String propertyName;
    private Integer numberOfCols;
    private XSSFCellStyle cellStyle;

    public ExcelBean(String headName, String propertyName) {
        this.headName = headName;
        this.propertyName = propertyName;
    }

    public ExcelBean(String headName, String propertyName, Integer numberOfCols) {
        this.headName = headName;
        this.propertyName = propertyName;
        this.numberOfCols = numberOfCols;
    }
}
