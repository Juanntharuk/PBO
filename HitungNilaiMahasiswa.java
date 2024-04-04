import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;


public class HitungNilaiMahasiswa extends JFrame implements ActionListener{
    // Komponen GUI
    private JLabel labelJudul, labelNama, labelNIM, labelNilaiTugas, labelNilaiKuis, labelNilaiUTS, labelNilaiUAS, labelOutputNama, labelOutputNIM, labelOutputRataRata, labelOutputGrade, labelOutputKeterangan;
    private JTextField fieldNama, fieldNIM, fieldNilaiTugas, fieldNilaiKuis, fieldNilaiUTS, fieldNilaiUAS;
    private JButton buttonSimpan, buttonHapus, buttonBatal;


    public HitungNilaiMahasiswa() {
        super("Hitung Nilai Mahasiswa");
        setSize(900, 600);
        getContentPane().setBackground(new Color(0, 0, 102));
        setLayout(null);

        // Judul
        labelJudul = new JLabel("MENGHITUNG NILAI MAHASISWA");
        labelJudul.setBounds(350,15,250,100);
        labelJudul.setFont(new Font("Arial", Font.BOLD, 14));
        labelJudul.setForeground(Color.WHITE);

        // Inisialisasi komponen GUI
        labelNama = new JLabel("Nama");
        labelNama.setBounds(20,110, 80, 30);
        fieldNama = new JTextField();
        fieldNama.setBounds(120,110, 260, 30);
        labelNama.setForeground(Color.WHITE);
        

        labelNIM = new JLabel("NIM");
        labelNIM.setBounds(20, 150, 80, 30);
        fieldNIM = new JTextField();
        fieldNIM.setBounds(120, 150, 260, 30 );
        labelNIM.setForeground(Color.WHITE);
        
        labelNilaiTugas = new JLabel("Nilai Tugas");
        labelNilaiTugas.setBounds(20, 190, 80, 30);
        fieldNilaiTugas = new JTextField();
        fieldNilaiTugas.setBounds(120, 190, 260,30);
        labelNilaiTugas.setForeground(Color.WHITE);

        labelNilaiKuis = new JLabel("Nilai Kuis");
        labelNilaiKuis.setBounds(20, 230, 80, 30);
        fieldNilaiKuis = new JTextField();
        fieldNilaiKuis.setBounds(120, 230, 260, 30);
        labelNilaiKuis.setForeground(Color.WHITE);

        labelNilaiUTS = new JLabel("Nilai UTS");
        labelNilaiUTS.setBounds(20, 270, 80, 30);
        fieldNilaiUTS = new JTextField();
        fieldNilaiUTS.setBounds(120,270,260, 30);
        labelNilaiUTS.setForeground(Color.WHITE);

        labelNilaiUAS = new JLabel("Nilai UAS");
        labelNilaiUAS.setBounds(20,310,80,30);
        fieldNilaiUAS = new JTextField();
        fieldNilaiUAS.setBounds(120,310,260,30);
        labelNilaiUAS.setForeground(Color.WHITE);

        labelOutputNama = new JLabel("Nama:");
        labelOutputNama.setBounds(500,110,200,30);
        labelOutputNama.setForeground(Color.WHITE);

        labelOutputNIM = new JLabel("NIM:");
        labelOutputNIM.setBounds(500, 150,200,30);
        labelOutputNIM.setForeground(Color.WHITE);

        labelOutputRataRata = new JLabel("Rata-rata:");
        labelOutputRataRata.setBounds(500,190,200,30);
        labelOutputRataRata.setForeground(Color.WHITE);

        labelOutputGrade = new JLabel("Grade:");
        labelOutputGrade.setBounds(500,230,200,30);
        labelOutputGrade.setForeground(Color.WHITE);

        labelOutputKeterangan = new JLabel("Keterangan:");
        labelOutputKeterangan.setBounds(500,270,200,30);
        labelOutputKeterangan.setForeground(Color.WHITE);

        buttonSimpan = new JButton("Simpan");
        buttonSimpan.addActionListener(this);
        buttonSimpan.setBounds(170,380,150,70);

        buttonHapus = new JButton("Hapus");
        buttonHapus.setBounds(360,380,150,70);
        buttonHapus.addActionListener(this);

        buttonBatal = new JButton("Batal");
        buttonBatal.setBounds(550,380,150,70);
        buttonBatal.addActionListener(this);

        // Menambahkan komponen ke frame
        add(labelJudul);
        add(labelNama);
        add(fieldNama);
        add(labelOutputNama);
        add(labelNIM);
        add(fieldNIM);
        add(labelOutputNIM);
        add(labelNilaiTugas);
        add(fieldNilaiTugas);
        add(labelNilaiKuis);
        add(fieldNilaiKuis);
        add(labelNilaiUTS);
        add(fieldNilaiUTS);
        add(labelNilaiUAS);
        add(fieldNilaiUAS);
        add(buttonSimpan);
        add(buttonHapus);
        add(buttonBatal);
        add(labelOutputRataRata);
        add(labelOutputGrade);
        add(labelOutputKeterangan);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent x) {
        if (x.getSource() == buttonSimpan) {
            // Proses penghitungan rata-rata
            double nilaiTugas = Double.parseDouble(fieldNilaiTugas.getText());
            double nilaiKuis = Double.parseDouble(fieldNilaiKuis.getText());
            double nilaiUTS = Double.parseDouble(fieldNilaiUTS.getText());
            double nilaiUAS = Double.parseDouble(fieldNilaiUAS.getText());

            double RataRata = (nilaiTugas + nilaiKuis + nilaiUTS + nilaiUAS) / 4;
            String Grade = hitungGrade(RataRata);
            String keterangan = hitungKeterangan(Grade);

            // Menampilkan output
            labelOutputNama.setText("Nama: " + fieldNama.getText());
            labelOutputNIM.setText("NIM: " + fieldNIM.getText());
            labelOutputRataRata.setText("Rata-rata: " + RataRata);
            labelOutputGrade.setText("Grade: " + Grade);
            labelOutputKeterangan.setText("Keterangan: " + keterangan);

            // Kosongkan setiap field input
            fieldNama.setText("");
            fieldNIM.setText("");
            fieldNilaiTugas.setText("");
            fieldNilaiKuis.setText("");
            fieldNilaiUTS.setText("");
            fieldNilaiUAS.setText("");

        } else if (x.getSource() == buttonHapus) {
            // Mengosongkan semua field input
            fieldNama.setText("");
            fieldNIM.setText("");
            fieldNilaiTugas.setText("");
            fieldNilaiKuis.setText("");
            fieldNilaiUTS.setText("");
            fieldNilaiUAS.setText("");

            // Mengosongkan semua data output
            labelOutputNama.setText("Nama :");
            labelOutputNIM.setText("NIM :");
            labelOutputRataRata.setText("Rata-rata :");
            labelOutputGrade.setText("Grade :");
            labelOutputKeterangan.setText("Keterangan :");
            

        } else if (x.getSource() == buttonBatal) {
            // Mengosongkan semua field input
            fieldNama.setText("");
            fieldNIM.setText("");
            fieldNilaiTugas.setText("");
            fieldNilaiKuis.setText("");
            fieldNilaiUTS.setText("");
            fieldNilaiUAS.setText("");
        }
    }

    private String hitungGrade(double rataRata) {
        // Logika untuk menentukan grade berdasarkan rata-rata
        String grade;
        if (rataRata >= 85) {
            grade = "A";
        } else if (rataRata >= 70) {
            grade = "B";
        } else if (rataRata >= 55) {
            grade = "C";
        } else if (rataRata >= 40) {
            grade = "D";
        } else {
            grade = "E";
        }
        return grade;
    }

    private String hitungKeterangan(String grade) {
        // Logika untuk menentukan keterangan berdasarkan grade
        String keterangan;
        switch (grade) {
            case "A":
                keterangan = "Sangat Baik";
                break;
            case "B":
                keterangan = "Baik";
                break;
            case "C":
                keterangan = "Cukup";
                break;
            case "D":
                keterangan = "Kurang";
                break;
            default:
                keterangan = "Sangat Kurang";
                break;
        }
        return keterangan;
    }

    public static void main(String[] args) {
        new HitungNilaiMahasiswa();
    }
}
