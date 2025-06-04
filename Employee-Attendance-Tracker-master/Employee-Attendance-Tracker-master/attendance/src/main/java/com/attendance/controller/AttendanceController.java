package com.attendance.controller;

import com.attendance.Attendance;
import com.attendance.AttendanceStatus;
import com.attendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/employee/{employeeId}")
    public List<Attendance> getAttendanceByEmployeeAndDate(
            @PathVariable Long employeeId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return attendanceService.getAttendanceByEmployeeAndDate(employeeId, date);
    }

    @GetMapping("/date/{date}")
    public List<Attendance> getAttendanceByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return attendanceService.getAttendanceByDate(date);
    }

    @PostMapping("/mark")
    public void markAttendance(
            @RequestParam Long employeeId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam AttendanceStatus status) {
        attendanceService.markAttendance(employeeId, date, status);
    }
}

