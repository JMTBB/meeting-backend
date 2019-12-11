package per.lai.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoCollector {
    private boolean name;
    private boolean number;
    private boolean gender;
    private boolean org;
    private boolean fullId;
    private boolean pTime;
    private boolean needRoom;
}
