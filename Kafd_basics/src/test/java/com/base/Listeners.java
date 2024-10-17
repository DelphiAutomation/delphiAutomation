package com.base;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseUtilities implements ITestListener {
	ExtentTest test;
	EmailReport emailReport;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		extentReport();
		test = reports.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, result.getMethod().getMethodName() + "Test is passed");
		try {
			test.addScreenCaptureFromPath(screenShot(result.getMethod().getMethodName()),
					result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Entered in FAiled result");
		// TODO Auto-generated method stub
//		test.log(Status.FAIL, result.getMethod().getMethodName() + "Test is Failed");
		try {
			test.fail(result.getThrowable(), MediaEntityBuilder
					.createScreenCaptureFromPath(screenShot(result.getMethod().getMethodName())).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.fail(result.getThrowable());
		try {
			test.addScreenCaptureFromPath(screenShot(result.getMethod().getMethodName()),
					result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			screenShot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMissingGroup() + "Test is Skipped");
		try {
			test.addScreenCaptureFromPath(screenShot(result.getMethod().getMethodName()),
					result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		emailReport = new EmailReport();
		try {
			emailReport.emailReportGenerator();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		reports.flush();
	}

}
