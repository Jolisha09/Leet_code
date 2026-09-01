class Solution
{
    public String removeOccurrences(String s, String part)
    {
        while (s.indexOf(part) != -1)
        {
            int start = s.indexOf(part);
            s = s.substring(0, start) + s.substring(start + part.length());
        }

        return s;
    }
}