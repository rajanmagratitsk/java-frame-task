import java.awt.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Random;
import javax.swing.*;

public class WeatherApp extends JFrame {

    JComboBox<String> cityBox;
    JTextArea weatherArea;
    JLabel timeLabel, dateLabel, tempLabel, conditionLabel;
    javax.swing.Timer timer;

    String[][] cities = {
        {"New York", "USA", "-5"},
        {"London", "UK", "0"},
        {"Tokyo", "Japan", "9"},
        {"Sydney", "Australia", "11"},
        {"Dubai", "UAE", "4"},
        {"Mumbai", "India", "5.5"},
        {"Paris", "France", "1"},
        {"Cairo", "Egypt", "2"}
    };

    HashMap<String, String[]> weatherData = new HashMap<>();

    public WeatherApp() {
        setTitle("🌤️ Weather & Time Predictor");
        setSize(650, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        initializeWeatherData();

        JPanel topPanel = new JPanel();
        cityBox = new JComboBox<>();

        for (String[] c : cities) {
            cityBox.addItem(c[0] + ", " + c[1]);
        }

        JButton predictBtn = new JButton("Predict");
        JButton refreshBtn = new JButton("Refresh");

        topPanel.add(new JLabel("City:"));
        topPanel.add(cityBox);
        topPanel.add(predictBtn);
        topPanel.add(refreshBtn);

        JPanel centerPanel = new JPanel(new GridLayout(4,1));

        timeLabel = new JLabel("--:--:--", JLabel.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 30));

        dateLabel = new JLabel("Date", JLabel.CENTER);
        tempLabel = new JLabel("Temp", JLabel.CENTER);
        conditionLabel = new JLabel("Condition", JLabel.CENTER);

        centerPanel.add(timeLabel);
        centerPanel.add(dateLabel);
        centerPanel.add(tempLabel);
        centerPanel.add(conditionLabel);

        weatherArea = new JTextArea();
        weatherArea.setEditable(false);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.WEST);
        add(new JScrollPane(weatherArea), BorderLayout.CENTER);

        predictBtn.addActionListener(e -> predictWeather());
        refreshBtn.addActionListener(e -> {
            updateTime();
            predictWeather();
        });

        timer = new javax.swing.Timer(1000, e -> updateTime());
        timer.start();

        updateTime();
        predictWeather();

        setVisible(true);
    }

    void initializeWeatherData() {
        weatherData.put("New York", new String[]{"18","Cloudy","65%","12 km/h","Rain tomorrow"});
        weatherData.put("London", new String[]{"15","Rainy","80%","15 km/h","Wet week"});
        weatherData.put("Tokyo", new String[]{"22","Sunny","55%","8 km/h","Clear days"});
        weatherData.put("Sydney", new String[]{"25","Sunny","60%","10 km/h","Beach weather"});
        weatherData.put("Dubai", new String[]{"35","Hot","30%","5 km/h","Extreme heat"});
        weatherData.put("Mumbai", new String[]{"30","Humid","85%","7 km/h","Monsoon soon"});
        weatherData.put("Paris", new String[]{"17","Cloudy","70%","11 km/h","Pleasant"});
        weatherData.put("Cairo", new String[]{"32","Dry","25%","9 km/h","Dust storm"});
    }

    void updateTime() {
        int idx = cityBox.getSelectedIndex();
        double offset = Double.parseDouble(cities[idx][2]);

        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        ZonedDateTime local = utc.plusSeconds((long)(offset * 3600));

        timeLabel.setText(local.format(DateTimeFormatter.ofPattern("hh:mm:ss a")));
        dateLabel.setText(local.format(DateTimeFormatter.ofPattern("EEEE, MMM dd")));
    }

    void predictWeather() {
        int idx = cityBox.getSelectedIndex();
        String city = cities[idx][0];
        String[] w = weatherData.get(city);

        Random r = new Random();
        int temp = Integer.parseInt(w[0]) + r.nextInt(5)-2;

        tempLabel.setText("🌡️ " + temp + "°C");
        conditionLabel.setText("☁️ " + w[1]);

        StringBuilder sb = new StringBuilder();

        sb.append("City: ").append(city).append("\n\n");
        sb.append("Temperature: ").append(temp).append("°C\n");
        sb.append("Condition: ").append(w[1]).append("\n");
        sb.append("Humidity: ").append(w[2]).append("\n");
        sb.append("Wind: ").append(w[3]).append("\n\n");

        sb.append("Forecast:\n");
        for(int i=1;i<=3;i++){
            sb.append("Day ").append(i)
              .append(": ")
              .append(temp + r.nextInt(5)-2)
              .append("°C\n");
        }

        sb.append("\nAdvice: ").append(getAdvice(w[1]));

        weatherArea.setText(sb.toString());
    }

    String getAdvice(String c){
        if(c.contains("Sunny")) return "Go outside ☀️";
        if(c.contains("Rainy")) return "Take umbrella ☔";
        if(c.contains("Hot")) return "Drink water 💧";
        return "Have a good day 🙂";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WeatherApp());
    }
}