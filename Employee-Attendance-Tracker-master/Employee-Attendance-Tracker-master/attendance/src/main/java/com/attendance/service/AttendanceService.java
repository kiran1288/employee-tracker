package com.attendance.service;

import com.attendance.Attendance;
import com.attendance.AttendanceStatus;
import com.attendance.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAttendanceByEmployeeAndDate(Long employeeId, LocalDate date) {
        return attendanceRepository.findByEmployeeIdAndDate(employeeId, date);
    }

    public List<Attendance> getAttendanceByDate(LocalDate date) {
        return attendanceRepository.findByDate(date);
    }

    public void markAttendance(Long employeeId, LocalDate date, AttendanceStatus status) {
        Attendance attendance = new Attendance();
        attendance.setEmployeeId(employeeId);
        attendance.setDate(date);
        attendance.setStatus(status);
        attendanceRepository.save(attendance);
    }
}

