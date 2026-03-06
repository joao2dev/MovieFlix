package com.MovieFlix.mapper;

import com.MovieFlix.entity.Streaming;
import com.MovieFlix.request.StreamingRequest;
import lombok.experimental.UtilityClass;
import com.MovieFlix.response.StreamingResponse;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest request){
        return Streaming.builder()
                .name(request.name())
                .build();
    }
    public static StreamingResponse toResponse(Streaming streaming){
        return StreamingResponse.builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }
}
