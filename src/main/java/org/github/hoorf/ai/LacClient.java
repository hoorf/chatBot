package org.github.hoorf.ai;

import com.dtflys.forest.annotation.JSONBody;
import com.dtflys.forest.annotation.Post;

public interface LacClient {

    @Post("http://localhost:5000/lac")
     LacResponse request(@JSONBody LacRequest data);
}
