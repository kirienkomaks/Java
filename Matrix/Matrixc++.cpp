int main()
{
	int r = 3;
	int c = 3;
	int tab[r*c];
	
	for(int i = 0;i<r*c;i++)
	{
		tab[i] = i+1;
	}
	
	for(int i = 0;i<r;i++)
	{
		for(int j = 0; j<c;j++)
		{
			cout<<tab[r*i+j]<<"  ";
		}
		cout<<endl;
	}
	
	
	return 0;
}
