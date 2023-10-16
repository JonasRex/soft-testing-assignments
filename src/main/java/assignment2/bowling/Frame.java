package assignment2.bowling;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Frame {

    private Roll[] rolls;

    public Frame() {
        rolls = new Roll[2];
    }
}
