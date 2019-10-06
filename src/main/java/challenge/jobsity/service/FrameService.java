package challenge.jobsity.service;

import challenge.jobsity.model.frame.Frame;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

public interface FrameService {

    Frame createFrame(@NotNull String number,@NotNull  String roll1, @Nullable String roll2, @Nullable String roll3 );

}
