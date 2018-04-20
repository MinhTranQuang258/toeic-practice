package com.tqminh.vn.toeicpractice.services;

import java.io.IOException;

public interface PhotoService {

    int countPhoto() throws IOException;

    String loadFilePatch() throws IOException;
}
