package org.myProject.Listeners;

import io.qameta.allure.Allure;
import org.myProject.Utils.VideoRecorder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VideoListener implements ITestListener {

    private static final String RECORDING_DIR = "recordings/";
    private String testName;

    @Override
    public void onTestStart(ITestResult result) {
        testName = result.getMethod().getMethodName();
        try {
            VideoRecorder.startRecording(testName);
        } catch (Exception e) {
            System.err.println("Failed to start video recording for test: " + testName);
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        stopRecordingAndAttach();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        stopRecordingAndAttach();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        stopRecordingAndAttach();
    }

    @Override
    public void onStart(ITestContext context) {
        // Optional: logic before tests start
    }

    @Override
    public void onFinish(ITestContext context) {
        // Optional: logic after all tests finish
    }

    private void stopRecordingAndAttach() {
        try {
            VideoRecorder.stopRecording();
            File videoFile = new File(RECORDING_DIR + testName + ".avi");
            if (videoFile.exists()) {
                try (FileInputStream fis = new FileInputStream(videoFile)) {
                    Allure.addAttachment(testName + ".avi", "video/avi", fis, ".avi");
                }
            } else {
                System.err.println("Video file not found: " + videoFile.getAbsolutePath());
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("Recorded video not found for: " + testName);
            fnfe.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error stopping recording or attaching video for: " + testName);
            e.printStackTrace();
        }
    }
}
