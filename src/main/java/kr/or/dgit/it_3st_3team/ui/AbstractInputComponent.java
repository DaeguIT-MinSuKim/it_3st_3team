package kr.or.dgit.it_3st_3team.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AbstractInputComponent<T> extends JPanel {
	private GridBagConstraints constraints;
	protected JPanel pCmp;
	protected GridBagLayout gbl;
	
	public AbstractInputComponent(String title) {
		constraints = new GridBagConstraints();
		
		gbl = new GridBagLayout();
		gbl.columnWeights = new double[]{0.0, 1.0};
		gbl.columnWidths = new int[]{150, 200};
		setLayout(gbl);
		
		JLabel lblTitle = new JLabel(title);
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		pCmp = new JPanel(new GridLayout(1, 0, 5, 0));
		
		addComponentToPanel(lblTitle, 0, 0, 1, 1, 0.2, GridBagConstraints.NONE);
		addComponentToPanel(pCmp,     1, 0, 2, 1, 0.3, GridBagConstraints.BOTH);
	}
	
	public void addComponentToPanel(JComponent comp, int x, int y, int width, int height, double weightx, int fill){
		
		//그리드 상의 컴포넌트의 좌표
		constraints.gridx = x;
		constraints.gridy = y;	

		//그리드 상에서 수평축, 수직축에서 점유해야할 셀의 수를 지정
		constraints.gridwidth = width;
		constraints.gridheight = height;
		
		//컴포넌트포다 그리드 셀이 좀더 넓을경우, 컴포넌트 사이즈를 리사이징 한다. - BOTH, VIRTICAL, HORIZONTAL, NONE
		//GridBagConstraints.NONE: 가득 채우지 않고, 기본크기로 나둠(기본)
		//GridBagConstraints.HORIZONTAL: 수평방향으로 가득 채움
		//GridBagConstraints.VERTICAL: 수직방향으로 가득 채움
		//GridBagConstraints.BOTH: 수평,수직방향 모두 가득 채움
		constraints.fill = fill;
		
		//창크기가 변해 그리드의 크기가 변할 경우 컴포넌트의 크기 변화를 남은공간에 대한 배분 - 0.0 ~ 1.0
		//- 가중치 계산은 [ 컴포넌트 가중치 값 / 전체 컴포넌트 가중치의 합계 ] 이다. 즉, 각 컴포넌트 가중치의 전체합은 분모로 쓰인다
		
		// 3개의 컴포넌트를 배치할 경우
		//기본 weightx,weighty의 값은 0.0의 값을 가지므로, 3개의 컴포넌트는 남은 공간에 대한 공간을 할당받지 못하고 뭉쳐서 가운데 정렬되어 배치된다.
		//- 3개의 컴포넌트가 각각 가중치값이 0.2, 0.2, 0.2를 가진경우. 물론 1.0, 1.0, 1.0을 가지더라도 동일하다. (계산해보면 0.2/(0.2+0.2+0.2), 1/(1+1+1)로 동일하다.)
		//3개의 컴포넌트가 각각 0.0, 0.2, 0.4의 가중치를 가지는 경우
		//- 첫번째 컴포넌트는 가중치가 0이기 때문에 남은 공간을 하나도 받지 못하고, 나머지 두개의 컴포넌트가 1:2 의 비율로 남은 공간을 가지게 된다.(전체 0:1:2 비율)
		constraints.weightx = weightx;
		constraints.weighty = 0.1;
		
		//컴포넌트의 외부 패딩을 지정. 기본값은 0,0,0,0 top, left, bottom, right
		constraints.insets = new Insets(5,5,5,5);  //top padding 
		
		//컴포넌트의 내부 패딩을 지정 기본값은 0
		constraints.ipadx = 0;
		constraints.ipady = 0;
		
		//컴포넌트를 여백의 어디에 위치사용가능한 공간보다 컴포넌트가 작을 경우 배치 될 방향을 지정
		//CENTER, EAST, NORTH, NORTHEAST, NORTHWEST, SOUTH, SOUTHEAST, SOUTHWEST, WEST
		constraints.anchor = GridBagConstraints.CENTER;
		add(comp, constraints);
	}
}
