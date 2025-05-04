package work.dirtsai.framework.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DeletedEnum {

    YES(true),
    NO(false);

    private final Boolean value;
}