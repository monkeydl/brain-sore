def longest_subsequence_word(s, d)
  output_strings = Array.new(d.size)

  d.each_with_index do |text, index|
    output_strings[index] ||= ''
    s.split('').each do |s_char|
      if text[0] == s_char
        output_strings[index] += s_char
        text = text[1..-1]
      end
    end
  end

  output_strings.sort_by(&:length)
  output_strings.reverse!
  output_strings[0]
end
