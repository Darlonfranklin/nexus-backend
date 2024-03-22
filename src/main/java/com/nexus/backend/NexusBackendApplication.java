package com.nexus.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.management.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

@SpringBootApplication
public class NexusBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(NexusBackendApplication.class, args);

		ZonedDateTime currentDateTime = ZonedDateTime.now();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.forLanguageTag("pt-BR"));
		String formattedDate = currentDateTime.format(dateFormatter);
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.forLanguageTag("pt-BR"));
		String formattedTime = currentDateTime.format(timeFormatter);
		String dayOfWeek = currentDateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("pt-BR"));


		RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
		String jvmName = runtimeMXBean.getVmName();
		String jvmVersion = runtimeMXBean.getVmVersion();

		OperatingSystemMXBean osMXBean = ManagementFactory.getOperatingSystemMXBean();
		String osName = osMXBean.getName();
		String osArch = osMXBean.getArch();
		String osVersion = osMXBean.getVersion();

		MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
		MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
		long usedMemory = heapMemoryUsage.getUsed() / (1024 * 1024);
		long maxMemory = heapMemoryUsage.getMax() / (1024 * 1024);
		System.out.println("=========================================================");
		System.out.println("\u001B[32m Aplicação iniciada em: " + formattedDate + " " + formattedTime + " " + dayOfWeek);
		System.out.println("=========================================================");
		System.out.println("\u001B[33mInformações sobre a JVM:");
		System.out.println("\u001B[33mNome da JVM: " + jvmName);
		System.out.println("\u001B[33mVersão da JVM: " + jvmVersion);
		System.out.println("=========================================================");
		System.out.println("\u001B[34mInformações sobre o Sistema Operacional:");
		System.out.println("\u001B[34mNome do SO: " + osName);
		System.out.println("\u001B[34mArquitetura do SO: " + osArch);
		System.out.println("\u001B[34mVersão do SO: " + osVersion);
		System.out.println("=========================================================");
		System.out.println("\u001B[31mInformações sobre a Memória:");
		System.out.println("\u001B[31mMemória usada: " + usedMemory + " MB");
		System.out.println("\u001B[31mMemória máxima: " + maxMemory + " MB");
		System.out.println("=========================================================");
	}

}
